package com.oms.service_impl;

import com.oms.Entity.Project;
import com.oms.dto.ProjectDto;
import com.oms.exceptions.ResourceNotFoundException;
import com.oms.repositories.ProjectRepository;
import com.oms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProject(ProjectDto projectDto) {
        try {
            Project project = toProjectEntity(projectDto);
            projectRepository.save(project);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateProject(ProjectDto projectDto, Integer projectId) {
        try {
            Project project = projectRepository.findById(projectId).orElse(null);

            if (project != null) {

                project.setAssignedTo(projectDto.getAssignedTo());
                project.setClientName(projectDto.getClientName());
                project.setDescription(projectDto.getDescription());
                project.setDuration(projectDto.getDuration());
                project.setEndDate(projectDto.getEndDate());
                project.setProjectAssignment(projectDto.getProjectAssignment());
                project.setProjectBugs(projectDto.getProjectBugs());
                project.setProjectName(projectDto.getProjectName());
                project.setStartDate(projectDto.getStartDate());
                project.setStatus(projectDto.getStatus());

                projectRepository.save(project);
            }
        } catch (Exception e) {

        }
    }
    @Override
    public List<ProjectDto> getAllProjects() {
        try {
            List<Project> projects = this.projectRepository.findAll();
            List<ProjectDto> projectDtos = projects.stream().map(this::toProjectDto).collect(Collectors.toList());

            return projectDtos;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<ProjectDto> getProjectById(Integer projectId) {
        try {
            Project project = this.projectRepository.findById(projectId)
                    .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));
            return Optional.ofNullable(this.toProjectDto(project));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteProjectById(Integer projectId) {
        try {
            projectRepository.deleteById(projectId);
        } catch (Exception e) {

        }
    }
    public ProjectDto toProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(project.getProjectId());
        projectDto.setAssignedTo(project.getAssignedTo());
        projectDto.setClientName(project.getClientName());
        projectDto.setDescription(project.getDescription());
        projectDto.setDuration(project.getDuration());
        projectDto.setEndDate(project.getEndDate());
        projectDto.setProjectAssignment(project.getProjectAssignment());
        projectDto.setProjectBugs(project.getProjectBugs());
        projectDto.setProjectName(project.getProjectName());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setStatus(project.getStatus());

        return projectDto;
    }

    public Project toProjectEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectId(project.getProjectId());
        project.setAssignedTo(projectDto.getAssignedTo());
        project.setClientName(projectDto.getClientName());
        project.setDescription(projectDto.getDescription());
        project.setDuration(projectDto.getDuration());
        project.setEndDate(projectDto.getEndDate());
        project.setProjectAssignment(projectDto.getProjectAssignment());
        project.setProjectBugs(projectDto.getProjectBugs());
        project.setProjectName(projectDto.getProjectName());
        project.setStartDate(projectDto.getStartDate());
        project.setStatus(projectDto.getStatus());

        return project;
    }

}
