package com.oms.controller;

import com.oms.dto.TaskDto;
import com.oms.dto.UserDto;
import com.oms.exceptions.PageNotFoundException;
import com.oms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add-task/{userId}")
    public ResponseEntity<String> addTask(@RequestBody TaskDto taskDto, @PathVariable("userId") Integer userId) {
        try {
            this.taskService.createTask(taskDto, userId);
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

    @GetMapping("/get-all-tasks/{page}")
    public ResponseEntity<List<TaskDto>> showAllTasks(@PathVariable("page") Integer page) throws PageNotFoundException {
        List<TaskDto> allTasks = this.taskService.getAllTasks(page);
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTask(@PathVariable("taskId") Integer taskId) {
        try {
            this.taskService.deleteTaskById(taskId);
            return ResponseEntity.ok("Task deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete task: " + e.getMessage());
        }
    }

    @GetMapping("/get-tasks-user/{page}/{userId}")
    public ResponseEntity<List<TaskDto>> getTaskOfParticularUser(@PathVariable("page") Integer page, @PathVariable("userId") Integer userId) throws PageNotFoundException {
        List<TaskDto> taskOfUser = this.taskService.getTaskOfUser(page, userId);
        return new ResponseEntity<>(taskOfUser, HttpStatus.OK);
    }
}
