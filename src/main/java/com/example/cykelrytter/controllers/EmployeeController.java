package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Employee;
import com.example.cykelrytter.services.IEmployeeService;
import com.example.cykelrytter.services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
public class EmployeeController {
    private IEmployeeService employeeService;
    private ImageService imageService;

    public EmployeeController(IEmployeeService employeeService, ImageService imageService) {
        this.employeeService = employeeService;
        this.imageService = imageService;
    }

    @GetMapping("/get/allEmployees")
    public ResponseEntity<Set<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/employee")
    public ResponseEntity<Employee> create (@RequestBody Employee employee){
        String employeeUrl = employee.getImgURL();
        String urlToSave = imageService.convertUrl(employeeUrl);
        employee.setImgURL(urlToSave);
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") Long employeeId){
        if (employeeService.findById(employeeId).isPresent()){
            employeeService.deleteById(employeeId);
            return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete employee", HttpStatus.OK);
        }
    }
}
