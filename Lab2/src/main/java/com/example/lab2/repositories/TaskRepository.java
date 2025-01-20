package com.example.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab2.models.TaskEntity;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}