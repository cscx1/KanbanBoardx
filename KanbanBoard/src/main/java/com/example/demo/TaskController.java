package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/")
    public Task createTask(@RequestBody Task task) {
        Task savedTask = taskRepository.save(task);
        messagingTemplate.convertAndSend("/topic/tasks", savedTask);
        return savedTask;
    }

    // Other CRUD operations

}
