package com.example.lab1.services;

import com.example.lab1.models.BookEntity;
import com.example.lab1.models.dto.BookRequest;
import com.example.lab1.models.AuthorEntity;
import com.example.lab1.repositories.BookRepository;
import com.example.lab1.repositories.AuthorRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class BookService {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private AuthorRepository authorRepository;

    // Получить список всех книг
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    // Создать новую книгу
    public Integer create(BookRequest bookRequest) {
        BookEntity book = new BookEntity();
        book.setTitle(bookRequest.getTitle());
        book.setPublicationYear(bookRequest.getPublicationYear());

        // Найти автора по ID и установить связь
        AuthorEntity author = authorRepository.findById(bookRequest.getAuthorId());
        if (author == null) {
            throw new IllegalArgumentException("Author with ID " + bookRequest.getAuthorId() + " not found");
        }
        book.setAuthor(author);

        bookRepository.persist(book);
        return book.getId();
    }

    // Удалить книгу по ID
    public void delete(Integer bookId) {
        bookRepository.delete(bookId);
    }
}
