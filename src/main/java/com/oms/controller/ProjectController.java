package com.oms.controller;

import com.oms.Entity.Project;
import com.oms.dto.ProjectDto;
import com.oms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping("/add-project")
    public ResponseEntity<String> addProject(@RequestBody ProjectDto projectDto) {
        try {
            this.projectService.createProject(projectDto);
            return ResponseEntity.ok("Project created successfully.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create project: " + e.getMessage());
        }
    }

    @PutMapping("/update-project/{projectId}")
    public ResponseEntity<String> updateProject(@RequestBody ProjectDto projectDto, @PathVariable("projectId") Integer projectId) {
        try {
            this.projectService.updateProject(projectDto, projectId);
            return ResponseEntity.ok("Project updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update project: " + e.getMessage());
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ProjectDto>> showAllProjects() {
        try {
            List<ProjectDto> allProjects = this.projectService.getAllProjects();
            return ResponseEntity.ok(allProjects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get/{projectId}")
    public ResponseEntity<Optional<ProjectDto>> showProject(@PathVariable("projectId") Integer projectId) {
        try {
            Optional<ProjectDto> projectById = this.projectService.getProjectById(projectId);
            if (projectById.isPresent()) {
                return ResponseEntity.ok(projectById);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable("projectId") Integer projectId) {
        try {
            this.projectService.deleteProjectById(projectId);
            return ResponseEntity.ok("Project deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete project: " + e.getMessage());
        }
    }


}
