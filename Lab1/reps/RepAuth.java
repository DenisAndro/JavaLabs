package com.example.lab1.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab1.models.Author;

import java.util.List;

@Stateless
public class AuthorRepository {
    @PersistenceContext
    private EntityManager em;

    // Найти всех авторов
    public List<Author> findAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    // Сохранить нового автора
    public void persist(Author author) {
        em.persist(author);
    }

    // Удалить автора по ID
    public void delete(int authorId) {
        Author author = em.find(Author.class, authorId);
        if (author != null) {
            em.remove(author);
        }
    }

    // Найти автора по ID
    public Author findById(int authorId) {
        return em.find(Author.class, authorId);
    }
}
