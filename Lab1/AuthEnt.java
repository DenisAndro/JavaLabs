package com.example.lab1.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкрементируемый ID
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100) // Поле name, обязательное
    private String name;

    @Column(name = "birth_date") // Поле birth_date, может быть NULL
    private LocalDate birthDate;
}
