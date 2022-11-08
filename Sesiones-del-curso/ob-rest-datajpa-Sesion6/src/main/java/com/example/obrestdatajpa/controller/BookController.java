package com.example.obrestdatajpa.controller;


import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD sobre la entidad Book

    // buscar todos los libros

    /**
     * http://localhost:8081/api/book
     * @return
     */

    @GetMapping("/api/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }


    // buscar solo un libro en case segun su id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {

        Optional<Book> bookOpt = bookRepository.findById(id);

        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();

    }
        // crear un nuevo libro en base de datos
        @PostMapping("/api/books")
        public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers ) {

            System.out.println(headers.get("User-Agent"));

            return bookRepository.save(book);

        }
        // actualizar libro existente en base de datos


        // borrar un libro en base de datos



}
