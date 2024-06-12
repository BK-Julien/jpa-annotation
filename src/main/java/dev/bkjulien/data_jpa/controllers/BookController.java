package dev.bkjulien.data_jpa.controllers;

import dev.bkjulien.data_jpa.dtos.BookDTO;
import dev.bkjulien.data_jpa.models.BookModel;
import dev.bkjulien.data_jpa.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController @RequestMapping(path = "/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookDTO));
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id)  {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully .");
    }

}
