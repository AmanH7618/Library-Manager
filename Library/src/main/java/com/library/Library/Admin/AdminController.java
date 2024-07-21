package com.library.Library.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService ads;

    @GetMapping("/details")
    public List<Admin> adminDetails(){
        return ads.adminDetails();
    }
    @PostMapping("/register")
    public void registerAdmin(@RequestBody Admin admin){
        ads.registerAdmin(admin);
    }

}
