package com.oms.controller;

import com.oms.dto.TaskDto;
import com.oms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add-task")
    public ResponseEntity<String> addTask(@RequestBody TaskDto taskDto) {
        try {
            this.taskService.createTask(taskDto);
            return ResponseEntity.ok("Task created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create task: " + e.getMessage());
        }
    }

    @PutMapping("/update-task/{taskId}")
    public ResponseEntity<String> updateTask(@RequestBody TaskDto taskDto, @PathVariable("taskId") Integer taskId) {
        try {
            this.taskService.updateTask(taskDto, taskId);
            return ResponseEntity.ok("Task updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update task: " + e.getMessage());
        }
    }

    @GetMapping("/get-all-tasks")
    public ResponseEntity<List<TaskDto>> showAllTasks() {
        try {
            List<TaskDto> allTasks = this.taskService.getAllTasks();
            return ResponseEntity.ok(allTasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get-task/{taskId}")
    public ResponseEntity<Optional<TaskDto>> showTask(@PathVariable("taskId") Integer taskId) {
        try {
            Optional<TaskDto> taskById = this.taskService.getTaskById(taskId);
            if (taskById.isPresent()) {
                return ResponseEntity.ok(taskById);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }

    }

    @DeleteMapping("/delete-task/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable("taskId") Integer taskId) {
        try {
            this.taskService.deleteTaskById(taskId);
            return ResponseEntity.ok("Task deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete task: " + e.getMessage());
        }
    }
}
