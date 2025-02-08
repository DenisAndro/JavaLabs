package com.example.lab3.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.lab3.models.TaskEntity;
import com.example.lab3.models.dto.TaskRequest;
import com.example.lab3.repositories.TaskRepository;
import com.example.lab3.utils.ObjectToDomTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
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
    public String getTasks(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("tasks");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<TaskEntity> tasks = taskRepository.findAll();
        for (TaskEntity task : tasks) {

            transformer.transform(element, task, "task");
        }

        model.addAttribute("tasks", element);
        return "tasks";
    }

}