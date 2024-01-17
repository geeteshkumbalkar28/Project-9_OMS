package com.oms.service;

import com.oms.dto.ProjectDto;
import com.oms.exceptions.ProjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    void createProject(ProjectDto projectDto);
    void updateProject(ProjectDto projectDto, Integer projectId);
    List<ProjectDto> getAllProjects(Integer id) throws ProjectNotFoundException;
    Optional<ProjectDto> getProjectById(Integer projectId);
    void deleteProjectById(Integer projectId);
}
