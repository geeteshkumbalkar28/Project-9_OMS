package com.oms.Entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer task_id;

    @Column
    private String assignedDate;

    @Column
    private String assignedEndDate;

    @Column
    private String assignedTo;

    @Column
    private String calls;

    @Column
    private String comments;

    @Column
    private String completedTask;

    @Column(name = "description")
    private String description;

    @Column(nullable = false)
    private Boolean done;

    @Column
    private OffsetDateTime dueDate;

    @Column(nullable = false)
    private Boolean inProgress;

    @Column
    private String message;

    @Column
    private String noOfTask;

    @Column
    private String pendingTask;

    @Column
    private String projectName;

    @Column(nullable = false)
    private Boolean status;

    @Column
    private String task;

    @Column
    private String taskName;

    @Column
    private String taskSubmitted;

    @Column
    private String totalCall;

    @Column
    private OffsetDateTime totalCallAttended;

    @Column
    private String totalPeopleConsulted;

    @Column
    private String totalReplies;

    @OneToMany(mappedBy = "task")
    private Set<Token> taskTokens;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
    private Set<UserTask> userTasks = new HashSet<>();


    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

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

    public Set<Token> getTaskTokens() {
        return taskTokens;
    }

    public void setTaskTokens(Set<Token> taskTokens) {
        this.taskTokens = taskTokens;
    }

    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Task(Integer task_id, String assignedDate, String assignedEndDate, String assignedTo, String calls,
                String comments, String completedTask, String description, Boolean done, OffsetDateTime dueDate,
                Boolean inProgress, String message, String noOfTask, String pendingTask, String projectName, Boolean status,
                String task, String taskName, String taskSubmitted, String totalCall, OffsetDateTime totalCallAttended,
                String totalPeopleConsulted, String totalReplies, Set<Token> taskTokens) {
        super();
        this.task_id = task_id;
        this.assignedDate = assignedDate;
        this.assignedEndDate = assignedEndDate;
        this.assignedTo = assignedTo;
        this.calls = calls;
        this.comments = comments;
        this.completedTask = completedTask;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
        this.inProgress = inProgress;
        this.message = message;
        this.noOfTask = noOfTask;
        this.pendingTask = pendingTask;
        this.projectName = projectName;
        this.status = status;
        this.task = task;
        this.taskName = taskName;
        this.taskSubmitted = taskSubmitted;
        this.totalCall = totalCall;
        this.totalCallAttended = totalCallAttended;
        this.totalPeopleConsulted = totalPeopleConsulted;
        this.totalReplies = totalReplies;
        this.taskTokens = taskTokens;
    }

    public Set<UserTask> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(Set<UserTask> userTasks) {
        this.userTasks = userTasks;
    }
}