package com.example.lab1.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкрементируемый ID
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 200) // Поле title, обязательное
    private String title;

    @Column(name = "publication_year", nullable = false) // Поле publication_year, обязательное
    private Integer publicationYear;

    @ManyToOne(fetch = FetchType.LAZY) // Связь с AuthorEntity (многие книги могут быть у одного автора)
    @JoinColumn(name = "author_id", nullable = false) // Внешний ключ author_id
    private AuthorEntity author;
}
