package com.oms.service_impl;

import com.oms.Entity.Task;
import com.oms.Entity.UserTask;
import com.oms.Entity.Users;
import com.oms.dto.TaskDto;
import com.oms.exceptions.PageNotFoundException;
import com.oms.exceptions.ResourceNotFoundException;
import com.oms.exceptions.UserNotFoundException;
import com.oms.repositories.TaskRepository;
import com.oms.repositories.UsersRepository;
import com.oms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public void createTask(TaskDto taskDto, Integer userId) {


        Users user = this.usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        try {
            Task task = toTaskEntity(taskDto);
            UserTask userTask = new UserTask();
            userTask.setUser(user);
            userTask.setTask(task);
            user.getUserTasks().add(userTask);
            taskRepository.save(task);
            usersRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateTask(TaskDto taskDto, Integer taskId) {
        try {
            Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

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
    public List<TaskDto> getAllTasks(Integer id) throws PageNotFoundException {


        List<Task> tasks = taskRepository.findAll();

        if (tasks.isEmpty()) {
            throw new UserNotFoundException("No users found");
        }

        int pageSize = 10;
        int totalPages = (int) Math.ceil((double) tasks.size() / pageSize);

        if (id >= totalPages) {
            throw new PageNotFoundException("Page not found");
        }

        int start = id * pageSize;
        int end = Math.min((id + 1) * pageSize, tasks.size());

        List<TaskDto> listOfTaskDto = new ArrayList<>();

        for (int i = start; i < end; i++) {
            TaskDto dto = toTaskDto(tasks.get(i));
            dto.setTaskId(tasks.get(i).getTask_id());
            listOfTaskDto.add(dto);
        }

        return listOfTaskDto;

    }

    @Override
    public Optional<TaskDto> getTaskById(Integer taskId) {
        try {
            Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));
            return Optional.ofNullable(this.toTaskDto(task));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteTaskById(Integer taskId) {

        Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

        try {
            this.taskRepository.deleteById(taskId);
        } catch (Exception e) {
        }
    }

    //get task of particular user
    @Override
    public List<TaskDto> getTaskOfUser(Integer id,Integer userId) throws PageNotFoundException {
        Users users = this.usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        List<UserTask> userTasks = users.getUserTasks();

        if (userTasks.isEmpty()) {
            throw new UserNotFoundException("No tasks found for the user");
        }

        int pageSize = 10;
        int totalPages = (int) Math.ceil((double) userTasks.size() / pageSize);

        if (id >= totalPages) {
            throw new PageNotFoundException("Page not found");
        }

        int start = id * pageSize;
        int end = Math.min((id + 1) * pageSize, userTasks.size());

        List<TaskDto> listOfTaskDto = new ArrayList<>();

        for (int i = start; i < end; i++) {
            UserTask userTask = userTasks.get(i);
            Task task = userTask.getTask();
            TaskDto dto = toTaskDto(task);
            dto.setTaskId(task.getTask_id());
            listOfTaskDto.add(dto);
        }

        return listOfTaskDto;

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
