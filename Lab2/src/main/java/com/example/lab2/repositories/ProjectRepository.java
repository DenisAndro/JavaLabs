package com.example.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab2.models.ProjectEntity;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
}