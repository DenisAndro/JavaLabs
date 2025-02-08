package com.example.lab3.controllers;

import lombok.RequiredArgsConstructor;
import com.example.lab3.models.dto.TaskRequest;
import com.example.lab3.services.TaskService;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @SneakyThrows
    public ResponseEntity <String> createTask(@RequestBody TaskRequest taskRequest) {

        return taskService.createTask(taskRequest);

    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity <String> deleteTask(@PathVariable UUID taskId) {
        return taskService.deleteTask(taskId);
    }

}