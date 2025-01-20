package com.example.lab1.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab1.models.Book;

import java.util.List;

@Stateless
public class BookRepository {
    @PersistenceContext
    private EntityManager em;

    // Найти все книги
    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    // Сохранить новую книгу
    public void persist(Book book) {
        em.persist(book);
    }

    // Удалить книгу по ID
    public void delete(int bookId) {
        Book book = em.find(Book.class, bookId);
        if (book != null) {
            em.remove(book);
        }
    }

    // Найти книгу по ID
    public Book findById(int bookId) {
        return em.find(Book.class, bookId);
    }
}
