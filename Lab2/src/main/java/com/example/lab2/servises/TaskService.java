package com.example.lab2.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.lab2.models.TaskEntity;
import com.example.lab2.models.dto.TaskRequest;
import com.example.lab2.repositories.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final ObjectMapper objectMapper;
    private final TaskRepository taskRepository;

    @SneakyThrows
    public ResponseEntity<String> getAllTasks() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(taskRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> createTask(TaskRequest taskRequest){
        TaskEntity task = new TaskEntity(
                randomUUID(),
                taskRequest.getTitle(),
                taskRequest.getDescription(),
                taskRequest.getStatus(),
                taskRequest.getProjectId()
        );
        taskRepository.save(task);
        return new ResponseEntity<>("Task created successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
        return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
    }
}