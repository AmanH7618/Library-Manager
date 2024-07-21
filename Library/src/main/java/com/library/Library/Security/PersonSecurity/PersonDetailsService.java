package com.library.Library.Security.PersonSecurity;

import com.library.Library.Person.Person;
import com.library.Library.Person.PersonRepository;
import com.library.Library.Security.AdminSecurity.AdminUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {
    @Autowired
    PersonRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person  = repo.findByName(username);
        if(person==null){
            throw new UsernameNotFoundException("Admin not found");

        }
        return new PersonUserDetails(person);
    }

}
