package com.example.cykelrytter.security.controller;

import com.example.cykelrytter.model.Admin;
import com.example.cykelrytter.security.service.JwtUserDetailsService;
import com.example.cykelrytter.security.JwtTokenManager;
import com.example.cykelrytter.security.model.JwtRequestModel;
import com.example.cykelrytter.security.model.JwtResponseModel;
import com.example.cykelrytter.services.IAdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class JwtController {
    private JwtUserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtTokenManager jwtTokenManager;
    private IAdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> signup(@RequestBody JwtRequestModel request){
        System.out.println("signup: username:" + request.getUsername() + " password: " + request.getPassword() );
        Admin admin = new Admin(request.getUsername(),request.getPassword());
        if(adminService.findByName(admin.getUsername()).size()==0) {
            if (adminService.save(admin) != null) {
                return ResponseEntity.ok(new JwtResponseModel("created admin: " + admin.getUsername() + " pw: " + admin.getPassword()));
            } else {
                return ResponseEntity.ok(new JwtResponseModel("error creating admin: " + admin.getUsername()));
            }
        }else {
                return ResponseEntity.ok(new JwtResponseModel("error: user admin: " + admin.getUsername()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request) throws Exception {
        // HttpServletRequest servletRequest is available from Spring, if needed.
        System.out.println("JwtController createToken Call: 4" + request.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("ADMIN_DISABLED", e);
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new JwtResponseModel("bad credentials"));
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = jwtTokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }


    @PostMapping("/getSecret")
    public ResponseEntity<Map> getSecret() {
        System.out.println("getSecret is called");
        Map<String,String > map = new HashMap<>();
        map.put("message","this is secret from server");
        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Map> deleteUser(@RequestBody Admin admin) { // hvis man kommer hertil, er token OK
        System.out.println("deleteAdmin is called with admin: " + admin.getUsername());
        // evt. findById, som finder hele objektet fra MySQL, inkl. id.
        List<Admin> admins =  adminService.findByName(admin.getUsername());
        Admin adminToDelete = admins.get(0);
        adminService.delete(adminToDelete);
        Map<String,String > map = new HashMap<>();
        map.put("message","admin deleted, if found " + admin.getUsername());
        return ResponseEntity.ok(map);
    }

}