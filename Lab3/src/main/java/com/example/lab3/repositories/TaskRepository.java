package com.example.lab3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab3.models.TaskEntity;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}