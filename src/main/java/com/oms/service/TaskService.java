package com.oms.service;

import com.oms.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void createTask(TaskDto taskDto);
    void updateTask(TaskDto taskDto, Integer taskId);
    List<TaskDto> getAllTasks();
    Optional<TaskDto> getTaskById(Integer taskId);
    void deleteTaskById(Integer taskId);
}
