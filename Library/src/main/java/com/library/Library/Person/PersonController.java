package com.library.Library.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class PersonController {
    @Autowired
    PersonService service;

    @PostMapping("/register")
    public void addUser(@RequestBody Person person){
        service.addUser(person);
    }

    @GetMapping("/all")
    public List<Person> allUsers(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<Person> findUser(@PathVariable Long id){
        return service.findUser(id);
    }
}
