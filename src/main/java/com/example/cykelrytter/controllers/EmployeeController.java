package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IEmployeeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private IEmployeeService employeeService;
    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }
}
