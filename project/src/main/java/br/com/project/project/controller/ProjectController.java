package br.com.project.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.project.model.Project;
import br.com.project.project.service.ProjectService;

@RequestMapping("/projects/v1")
@RestController
public class ProjectController {
    
    private ProjectService projectService;

    public ProjectController(ProjectService projectService){

        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id){

        return projectService.getProjectById(id);
    }

    @PostMapping
    public void saveProject(@RequestBody Project request){

        projectService.createProject(request);
    }

    @PutMapping("/{id}")
    public void updateProject(Long id, @RequestBody Project request){

        projectService.updateProjectById(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(Long id){

        projectService.deleteProject(id);
    }
}
