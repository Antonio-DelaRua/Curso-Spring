package com.example.obrestdatajpa.controller;


import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);


    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    /**
     * http://localhost:8081/api/book
     * @return
     *  buscar todos los libros
     */

    @GetMapping("/api/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }


    /**
     *  buscar solo un libro en case segun su id
     * @param id
     * @return
     */

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {

        Optional<Book> bookOpt = bookRepository.findById(id);

        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();

    }


    /**
     * crear un nuevo libro en base de datos
     * No colisiona con findAll porque son metodos diferentes.(GET - POST)
     * @param book
     * @param headers
     * @return
     */

        @PostMapping("/api/books")
            public ResponseEntity<Book>create(@RequestBody Book book, @RequestHeader HttpHeaders headers ) {

            System.out.println(headers.get("User-Agent"));

            if(book.getId() != null) {
                log.warn("ha ha ha no ha dicho la palabra magica ha ha ha");
                System.out.println("ha ha ha no ha dicho la palabra magica ha ha ha");
                return ResponseEntity.badRequest().build();

            }
            Book result = bookRepository.save(book);
            return ResponseEntity.ok(result);

        }


    /**
     * Actualizar un libro existente
     * @param book
     * @return
     */

    @PutMapping("/api/books/{id}")
        public ResponseEntity<Book> update(@RequestBody Book book){
            if(book.getId() == null){
                log.warn("ha ha ha no ha dicho la palabra magica ha ha ha");
                return ResponseEntity.badRequest().build();
            }
            if(!bookRepository.existsById(book.getId()))
                return ResponseEntity.notFound().build();

            Book result = bookRepository.save(book);
            return ResponseEntity.ok(result);

        }

    /**
     * borrar un libro en base de datos
     */

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if(!bookRepository.existsById(id)){
            log.warn("ha ha ha no ha dicho la palabra magica ha ha ha");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    /**
     * borrar todos
     */

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request of Deleting all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
