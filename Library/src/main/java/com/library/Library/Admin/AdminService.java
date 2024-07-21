package com.library.Library.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Admin> adminDetails(){
        return repo.findAll();
    }
    public void registerAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        repo.save(admin);
    }
}
