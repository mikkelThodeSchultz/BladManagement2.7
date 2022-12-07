package com.example.cykelrytter.services;


import com.example.cykelrytter.model.Admin;
import com.example.cykelrytter.repositories.AdminRepository;
import com.example.cykelrytter.security.config.SecurityConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class AdminService implements IAdminService{

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Set<Admin> findAll() {
        Set<Admin> admins = new HashSet<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    @Override
    public Admin save(Admin object) {
        if(object.getPassword() == null) {
            PasswordEncoder pw = SecurityConfiguration.passwordEncoder();
            object.setPassword(pw.encode(object.getPassword()));
        }
        return adminRepository.save(object);
    }

    @Override
    public void delete(Admin object) {
        adminRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Admin> findById(Long aLong) {
        return adminRepository.findById(aLong);
    }

    @Override
    public List<Admin> findByName(String name) {
        System.out.println("Userservice called findByName with argument: " + name);
        return adminRepository.findUserByName(name);
    }
}
