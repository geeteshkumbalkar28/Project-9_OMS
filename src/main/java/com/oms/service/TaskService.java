package com.oms.service;

import com.oms.dto.TaskDto;
import com.oms.exceptions.PageNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void createTask(TaskDto taskDto,Integer userId);
    void updateTask(TaskDto taskDto, Integer taskId);
    List<TaskDto> getAllTasks(Integer id) throws PageNotFoundException;
    Optional<TaskDto> getTaskById(Integer taskId);
    void deleteTaskById(Integer taskId);

    List<TaskDto> getTaskOfUser(Integer id,Integer userId) throws PageNotFoundException;
}
