package com.fays.book.Controller;

import com.fays.book.AuteurRepository;
import com.fays.book.Book;
import com.fays.book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {3

    @Autowired

    private BookRepository bookRepository;
     @Autowired
    private AuteurRepository auteurRepository;

    @GetMapping(value = "/book")
    public List<Book> getAllBookList()
    {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/book/{id}")
    public Book getbookById(@PathVariable ("id") Long id)
    {
        return bookRepository.findById(id).get();
    }

    @PutMapping(value = "/book/{id}")
    public void updateBookById(@PathVariable ("id") Long id, @RequestBody Book book) {

        var bookList = bookRepository.findById(id);
        if(bookList.isPresent()){
            book.setId(id);
            bookRepository.save(book);
        }
    }
    @PostMapping(value = "/book/{id}")
    public void create(@RequestBody Book book, @PathVariable ("id") long id){


       var auteur = auteurRepository.findById(id);
       if(auteur.isPresent()){
           book.setAuteur(auteur.get());
           bookRepository.save(book);
       }
    }

    @DeleteMapping(value = "/book/{id}")
    public void deleteById(@PathVariable ("id") Long id)
    {
        bookRepository.deleteById(id);
    }



}
