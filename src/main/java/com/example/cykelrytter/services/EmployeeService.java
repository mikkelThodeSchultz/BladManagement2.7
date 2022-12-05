package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Employee;
import com.example.cykelrytter.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<Employee> findAll() {
        Set<Employee> employees = new HashSet<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public void delete(Employee object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Employee> findById(Long aLong) {
        return Optional.empty();
    }
}
