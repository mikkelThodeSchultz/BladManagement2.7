package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.IAdminService;
import com.example.cykelrytter.services.IArtistService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private IAdminService adminService;
    public AdminController(IAdminService adminService){
        this.adminService = adminService;
    }
}
