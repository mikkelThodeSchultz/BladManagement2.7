package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    List<Admin> findUserByName(String name);

}
