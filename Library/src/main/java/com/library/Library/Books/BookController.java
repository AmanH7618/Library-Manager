package com.library.Library.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping("/add")
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @GetMapping("show")
    public List<Book> allBook(){
        return service.getAllBook();
    }


    @GetMapping("/available")
    public List<Book> available(){
        List<Book> allBooks = service.getAllBook();
        List<Book> availableBooks = new ArrayList<>();
        for(Book bk:allBooks){
            if(bk.getAvailable()==false){
                availableBooks.add(bk);
            }
        }
        return availableBooks;
    }



    @GetMapping("/findbook/{id}")
    public Optional<Book> findBook(@PathVariable Long id){
        return service.findBook(id);
    }

}
