package com.oms.dto;

import java.time.OffsetDateTime;

public class ProjectDto {
    private Integer projectId;
    private String assignedTo;
    private String clientName;
    private String description;
    private Integer duration;
    private OffsetDateTime endDate;
    private String projectAssignment;
    private String projectBugs;
    private String projectName;
    private OffsetDateTime startDate;
    private String status;

    // Getters
    public String getAssignedTo() {
        return assignedTo;
    }

    public String getClientName() {
        return clientName;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public String getProjectAssignment() {
        return projectAssignment;
    }

    public String getProjectBugs() {
        return projectBugs;
    }

    public String getProjectName() {
        return projectName;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public void setProjectAssignment(String projectAssignment) {
        this.projectAssignment = projectAssignment;
    }

    public void setProjectBugs(String projectBugs) {
        this.projectBugs = projectBugs;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
