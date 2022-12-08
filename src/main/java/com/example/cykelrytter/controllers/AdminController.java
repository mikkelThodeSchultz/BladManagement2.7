package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Admin;
import com.example.cykelrytter.model.NewsList;
import com.example.cykelrytter.services.IAdminService;
import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.INewsListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
public class AdminController {
    private IAdminService adminService;
    private INewsListService newsListService;

    public AdminController(IAdminService adminService, INewsListService newsListService) {
        this.adminService = adminService;
        this.newsListService = newsListService;
    }

    @GetMapping("/get/allEmails")
    public ResponseEntity<Set<NewsList>> getAll(){
        return new ResponseEntity<>(newsListService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/emailToList")
    public ResponseEntity<NewsList> create(@RequestBody NewsList newsList){
        return new ResponseEntity<>(newsListService.save(newsList), HttpStatus.OK);
    }

    //Så kan jeg tilføje et id til url'en i frontend
    @DeleteMapping("/delete/emailFromList/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") Long emailId){
        newsListService.deleteById(emailId);
        return new ResponseEntity<>("Du er nu frameldt vores nyhedsbrev", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Admin> login (){
        Optional<Admin> admin = adminService.findById((long)1);
        if(admin.isPresent()){
            Admin admin1 = admin.get();
            return new ResponseEntity<>(admin1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
