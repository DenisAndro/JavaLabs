package com.example.lab1.services;

import com.example.lab1.models.AuthorEntity;
import com.example.lab1.models.dto.AuthorRequest;
import com.example.lab1.repositories.AuthorRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class AuthorService {

    @Inject
    private AuthorRepository authorRepository;

    // Получить список всех авторов
    public List<AuthorEntity> getAll() {
        return authorRepository.findAll();
    }

    // Создать нового автора
    public Integer create(AuthorRequest authorRequest) {
        AuthorEntity author = new AuthorEntity();
        author.setName(authorRequest.getName());
        author.setBirthDate(authorRequest.getBirthDate());

        authorRepository.persist(author);
        return author.getId();
    }

    // Удалить автора по ID
    public void delete(Integer authorId) {
        authorRepository.delete(authorId);
    }
}
