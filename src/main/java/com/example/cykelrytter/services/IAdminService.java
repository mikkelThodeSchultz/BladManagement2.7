package com.example.cykelrytter.services;


import com.example.cykelrytter.model.Admin;

import java.util.List;

public interface IAdminService extends ICrudService<Admin,Long> {

    List<Admin> findByName(String name);

}
