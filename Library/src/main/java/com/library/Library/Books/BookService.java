package com.library.Library.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    public void addBook(Book book) {
        repo.save(book);
    }

    public List<Book> getAllBook() {
        return repo.findAll();
    }

    public Optional<Book> findBook(Long id) {
        return repo.findById(id);
    }
}
