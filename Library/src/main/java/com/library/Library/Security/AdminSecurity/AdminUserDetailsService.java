package com.library.Library.Security.AdminSecurity;

import com.library.Library.Admin.Admin;
import com.library.Library.Admin.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService implements UserDetailsService {
    @Autowired
    AdminRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin  = repo.findByName(username);
        if(admin==null){
            throw new UsernameNotFoundException("Admin not found");

        }
        return new AdminUserDetails(admin);
    }
}
