package dev.bkjulien.data_jpa.services;

import dev.bkjulien.data_jpa.dtos.BookDTO;
import dev.bkjulien.data_jpa.models.BookModel;
import dev.bkjulien.data_jpa.models.ReviewModel;
import dev.bkjulien.data_jpa.repositories.AuthorRepository;
import dev.bkjulien.data_jpa.repositories.BookRepository;
import dev.bkjulien.data_jpa.repositories.PublisherRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override @Transactional
    public BookModel saveBook(BookDTO bookDTO) {
        var book = new BookModel();
        book.setTitle(bookDTO.title());
        book.setPublisher(publisherRepository.findById(bookDTO.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookDTO.authorIds()).stream().collect(Collectors.toSet()));

        var reviewModel = new ReviewModel();
        reviewModel.setComment(bookDTO.reviewComment());
        reviewModel.setBook(book);

        book.setReview(reviewModel);

        return bookRepository.save(book);
    }

    @Override
    public List<BookModel> getBooks() {
        return bookRepository.findAll();
    }

    @Override @Transactional
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
