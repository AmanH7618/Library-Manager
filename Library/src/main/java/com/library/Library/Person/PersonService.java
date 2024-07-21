package com.library.Library.Person;

import com.library.Library.ExceptionHandler.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        repo.save(person);
    }

    public List<Person> getUsers() {
        return  repo.findAll();
    }


    public Optional<Person> findUser(Long id) {
        return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new UserNotFound("User is not registered please register")));
    }
}
