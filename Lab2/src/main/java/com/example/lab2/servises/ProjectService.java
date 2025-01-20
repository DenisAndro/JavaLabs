package com.example.lab2.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.lab2.repositories.ProjectRepository;
import com.example.lab2.models.ProjectEntity;
import com.example.lab2.models.dto.ProjectRequest;

import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ObjectMapper objectMapper;
    private final ProjectRepository projectRepository;

    @SneakyThrows
    public ResponseEntity<String> getAllProjects() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(projectRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> createProject(ProjectRequest projectRequest) {
        ProjectEntity project = new ProjectEntity(
                randomUUID(),
                projectRequest.getName(),
                projectRequest.getDescription(),
                projectRequest.getStartDate(),
                projectRequest.getEndDate()
        );
        projectRepository.save(project);
        return new ResponseEntity<>("Project created successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteProject(UUID projectId) {
        projectRepository.deleteById(projectId);
        return new ResponseEntity<>("Project deleted successfully", HttpStatus.OK);
    }
}