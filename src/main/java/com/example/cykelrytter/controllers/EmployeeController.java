package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Artist;
import com.example.cykelrytter.model.Employee;
import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
public class EmployeeController {
    private IEmployeeService employeeService;
    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/get/allEmployees")
    public ResponseEntity<Set<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/employee")
    public ResponseEntity<Employee> create (@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }
}
