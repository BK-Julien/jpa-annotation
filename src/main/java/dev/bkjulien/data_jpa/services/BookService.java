package dev.bkjulien.data_jpa.services;

import dev.bkjulien.data_jpa.dtos.BookDTO;
import dev.bkjulien.data_jpa.models.BookModel;

import java.util.List;
import java.util.UUID;

public interface BookService {
    BookModel saveBook(BookDTO bookDTO);
    List<BookModel> getBooks();
    void deleteBook(UUID id);
}
