package com.library.Library.Functions;

import com.library.Library.Books.Book;
import com.library.Library.Books.BookRepository;
import com.library.Library.Person.Person;
import com.library.Library.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionsService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    public Person assignBook(Long personId, Long bookId) {
        Person person = personRepository.findById(personId).orElseThrow(()->new RuntimeException("Person not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
        if (book.getHolder() != null) {
            throw new RuntimeException("Book is already assigned to another person");
        }
        if (person.getBook() != null) {
            throw new RuntimeException("Book is already assigned to you");
        }
        person.setBook(book);
        book.setHolder(person);
        personRepository.save(person);
        bookRepository.save(book);
        return person;
    }

    public Person returnBook(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow(()->new RuntimeException("Person not found"));
        Book book = person.getBook();
        book.setHolder(null);
        person.setBook(null);
        personRepository.save(person);
        bookRepository.save(book);
        return person;
    }
}
