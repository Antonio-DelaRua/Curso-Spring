package com.example.obrestdatajpa.controller;


import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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



    // crear un nuevo libro en base de datos



    // actualizar libro existente en base de datos



    // borrar un libro en base de datos




}
