package com.example.lab1.models.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AuthorRequest {
    private String name; // Имя автора
    private LocalDate birthDate; // Дата рождения автора
}
