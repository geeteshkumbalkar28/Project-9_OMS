package com.oms.service_impl;

import com.oms.Entity.Task;
import com.oms.dto.TaskDto;
import com.oms.exceptions.ResourceNotFoundException;
import com.oms.repositories.TaskRepository;
import com.oms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(TaskDto taskDto) {
        try {
            Task task = toTaskEntity(taskDto);
            taskRepository.save(task);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateTask(TaskDto taskDto, Integer taskId) {
        try {
            Task task = taskRepository.findById(taskId).orElse(null);

            if (task != null) {
                task.setAssignedDate(taskDto.getAssignedDate());
                task.setAssignedEndDate(taskDto.getAssignedEndDate());
                task.setAssignedTo(taskDto.getAssignedTo());
                task.setCalls(taskDto.getCalls());
                task.setComments(taskDto.getComments());
                task.setCompletedTask(taskDto.getCompletedTask());
                task.setDescription(taskDto.getDescription());
                task.setDone(taskDto.getDone());
                task.setDueDate(taskDto.getDueDate());
                task.setInProgress(taskDto.getInProgress());
                task.setMessage(taskDto.getMessage());
                task.setNoOfTask(taskDto.getNoOfTask());
                task.setPendingTask(taskDto.getPendingTask());
                task.setProjectName(taskDto.getProjectName());
                task.setStatus(taskDto.getStatus());
                task.setTask(taskDto.getTask());
                task.setTaskName(taskDto.getTaskName());
                task.setTaskSubmitted(taskDto.getTaskSubmitted());
                task.setTotalCall(taskDto.getTotalCall());
                task.setTotalCallAttended(taskDto.getTotalCallAttended());
                task.setTotalPeopleConsulted(taskDto.getTotalPeopleConsulted());
                task.setTotalReplies(taskDto.getTotalReplies());

                taskRepository.save(task);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaskDto> getAllTasks() {
        try {
            List<Task> users = this.taskRepository.findAll();
            List<TaskDto> userDtos = users.stream().map(user->this.toTaskDto(user)).collect(Collectors.toList());

            return userDtos;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<TaskDto> getTaskById(Integer taskId) {
        try {
             Task task=this.taskRepository.findById(taskId).orElseThrow(()->new ResourceNotFoundException("User","id",taskId));
            return Optional.ofNullable(this.toTaskDto(task));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteTaskById(Integer taskId) {
        Task task=this.taskRepository.findById(taskId).orElseThrow(()->new ResourceNotFoundException("User","id",taskId));
        try {
            taskRepository.deleteById(taskId);
        } catch (Exception e) {
        }
    }


    public TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(task.getTask_id());
        taskDto.setAssignedDate(task.getAssignedDate());
        taskDto.setAssignedEndDate(task.getAssignedEndDate());
        taskDto.setAssignedTo(task.getAssignedTo());
        taskDto.setCalls(task.getCalls());
        taskDto.setComments(task.getComments());
        taskDto.setCompletedTask(task.getCompletedTask());
        taskDto.setDescription(task.getDescription());
        taskDto.setDone(task.getDone());
        taskDto.setDueDate(task.getDueDate());
        taskDto.setInProgress(task.getInProgress());
        taskDto.setMessage(task.getMessage());
        taskDto.setNoOfTask(task.getNoOfTask());
        taskDto.setPendingTask(task.getPendingTask());
        taskDto.setProjectName(task.getProjectName());
        taskDto.setStatus(task.getStatus());
        taskDto.setTask(task.getTask());
        taskDto.setTaskName(task.getTaskName());
        taskDto.setTaskSubmitted(task.getTaskSubmitted());
        taskDto.setTotalCall(task.getTotalCall());
        taskDto.setTotalCallAttended(task.getTotalCallAttended());
        taskDto.setTotalPeopleConsulted(task.getTotalPeopleConsulted());
        taskDto.setTotalReplies(task.getTotalReplies());

        return taskDto;
    }

    public Task toTaskEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setTask_id(taskDto.getTaskId());
        task.setAssignedDate(taskDto.getAssignedDate());
        task.setAssignedEndDate(taskDto.getAssignedEndDate());
        task.setAssignedTo(taskDto.getAssignedTo());
        task.setCalls(taskDto.getCalls());
        task.setComments(taskDto.getComments());
        task.setCompletedTask(taskDto.getCompletedTask());
        task.setDescription(taskDto.getDescription());
        task.setDone(taskDto.getDone());
        task.setDueDate(taskDto.getDueDate());
        task.setInProgress(taskDto.getInProgress());
        task.setMessage(taskDto.getMessage());
        task.setNoOfTask(taskDto.getNoOfTask());
        task.setPendingTask(taskDto.getPendingTask());
        task.setProjectName(taskDto.getProjectName());
        task.setStatus(taskDto.getStatus());
        task.setTask(taskDto.getTask());
        task.setTaskName(taskDto.getTaskName());
        task.setTaskSubmitted(taskDto.getTaskSubmitted());
        task.setTotalCall(taskDto.getTotalCall());
        task.setTotalCallAttended(taskDto.getTotalCallAttended());
        task.setTotalPeopleConsulted(taskDto.getTotalPeopleConsulted());
        task.setTotalReplies(taskDto.getTotalReplies());

        return task;
    }


}
