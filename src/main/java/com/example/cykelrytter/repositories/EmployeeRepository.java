package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
