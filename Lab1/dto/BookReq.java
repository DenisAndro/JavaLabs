package com.example.lab1.models.dto;

import lombok.Data;

@Data
public class BookRequest {
    private String title; // Название книги
    private Integer publicationYear; // Год публикации книги
    private Integer authorId; // ID автора (внешний ключ)
}
