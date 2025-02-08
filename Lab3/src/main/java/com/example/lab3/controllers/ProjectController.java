package com.example.lab3.controllers;

import lombok.RequiredArgsConstructor;
import com.example.lab3.models.dto.ProjectRequest;
import com.example.lab3.services.ProjectService;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @SneakyThrows
    public ResponseEntity <String> createProject(@RequestBody ProjectRequest projectRequest) {

        return projectService.createProject(projectRequest);

    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity <String> deleteProject(@PathVariable UUID projectId) {
        return projectService.deleteProject(projectId);
    }
}