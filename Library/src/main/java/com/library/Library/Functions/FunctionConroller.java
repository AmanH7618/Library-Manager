package com.library.Library.Functions;

import com.library.Library.Books.BookService;
import com.library.Library.Person.Person;
import com.library.Library.Person.PersonService;
import com.library.Library.Security.PersonSecurity.PersonUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunctionConroller {
    @Autowired
    FunctionsService service;


    @PutMapping("assign")
    public Person assignBook( @RequestParam Long bookId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonUserDetails userDetails = (PersonUserDetails) authentication.getPrincipal();
        Long personId = userDetails.getPersonId();
        return service.assignBook(personId,bookId);
    }

    @PutMapping("returnBook")
    public Person returnBook(@RequestParam Long personId){
        return service.returnBook(personId);
    }
}
