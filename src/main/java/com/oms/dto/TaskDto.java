package com.oms.dto;

import java.time.OffsetDateTime;

public class TaskDto {
    private Integer taskId;
    private String assignedDate;
    private String assignedEndDate;
    private String assignedTo;
    private String calls;
    private String comments;
    private String completedTask;
    private String description;
    private Boolean done;
    private OffsetDateTime dueDate;
    private Boolean inProgress;
    private String message;
    private String noOfTask;
    private String pendingTask;
    private String projectName;
    private Boolean status;
    private String task;
    private String taskName;
    private String taskSubmitted;
    private String totalCall;
    private OffsetDateTime totalCallAttended;
    private String totalPeopleConsulted;
    private String totalReplies;

    // Getters and Setters for each field

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getAssignedEndDate() {
        return assignedEndDate;
    }

    public void setAssignedEndDate(String assignedEndDate) {
        this.assignedEndDate = assignedEndDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getCalls() {
        return calls;
    }

    public void setCalls(String calls) {
        this.calls = calls;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCompletedTask() {
        return completedTask;
    }

    public void setCompletedTask(String completedTask) {
        this.completedTask = completedTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public OffsetDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(OffsetDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNoOfTask() {
        return noOfTask;
    }

    public void setNoOfTask(String noOfTask) {
        this.noOfTask = noOfTask;
    }

    public String getPendingTask() {
        return pendingTask;
    }

    public void setPendingTask(String pendingTask) {
        this.pendingTask = pendingTask;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskSubmitted() {
        return taskSubmitted;
    }

    public void setTaskSubmitted(String taskSubmitted) {
        this.taskSubmitted = taskSubmitted;
    }

    public String getTotalCall() {
        return totalCall;
    }

    public void setTotalCall(String totalCall) {
        this.totalCall = totalCall;
    }

    public OffsetDateTime getTotalCallAttended() {
        return totalCallAttended;
    }

    public void setTotalCallAttended(OffsetDateTime totalCallAttended) {
        this.totalCallAttended = totalCallAttended;
    }

    public String getTotalPeopleConsulted() {
        return totalPeopleConsulted;
    }

    public void setTotalPeopleConsulted(String totalPeopleConsulted) {
        this.totalPeopleConsulted = totalPeopleConsulted;
    }

    public String getTotalReplies() {
        return totalReplies;
    }

    public void setTotalReplies(String totalReplies) {
        this.totalReplies = totalReplies;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
