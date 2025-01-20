package com.example.lab2.models.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ProjectRequest {
    private UUID id;             // ID проекта (опционально, для обновления)
    private String name;          // Название проекта
    private String description;   // Описание проекта
    private String startDate;     // Дата начала проекта
    private String endDate;       // Дата окончания проекта
}