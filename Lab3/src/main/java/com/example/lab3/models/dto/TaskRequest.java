package com.example.lab3.models.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class TaskRequest {
    private String title;        // Название задачи
    private String description;  // Описание задачи
    private String status;       // Статус задачи ("New", "In Progress", "Done")
    private UUID projectId;      // ID проекта, к которому принадлежит задача
}