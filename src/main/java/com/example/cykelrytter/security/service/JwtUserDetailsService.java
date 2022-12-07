package com.example.cykelrytter.security.service;

import com.example.cykelrytter.model.Admin;
import com.example.cykelrytter.services.IAdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private IAdminService adminService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(" JwtUserDetailsService loadUserByUsername Call: 5,6");
        // point mht. bruger database:
        // Brugere bliver oprettet ved /login. Der gemmes brugernavn og bcrypt encoded password
        // Når bruger efterfølgende logger på, hentes brugerens usr/pw fra databasen.
        // Herefter opretter man et nyt userdetails.User objekt med usr/pw fra databasen.
        // Spring Security vil herefter bruge bcrypt.compare() til at sammenligne clear-text pw fra
        // login-formular med datbasens bcrypt af pw. Hvis svaret er true, er brugeren godkendt.
        List<Admin> admins = adminService.findByName(username);
        System.out.println("admins from database: length: " + admins.size());
        if(admins.size()==1) {
            System.out.println("found the admin in Database: " + admins.get(0).getUsername());
                return new Admin(username,
                        admins.get(0).getPassword(), // "password" encoded her
                        // Point: Bcrypt can hash the same clear-text string many times: each time will lead to a different hashed string.
                        // You can check https://bcrypt-generator.com/ to verify if a cleartext string matches any bcrypt hash.
                        new ArrayList<>());
                // bcrypt example:  $2a$10$WG/h8E/8U6j48JOn7BnWTe7g9OenBlzapETPHeqZgrBxjcKmsWTmm
        }else{
                throw new UsernameNotFoundException("Admin not found with username: " + username);
        }
    }
}
