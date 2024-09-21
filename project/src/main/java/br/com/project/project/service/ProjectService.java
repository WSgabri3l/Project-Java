package br.com.project.project.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.project.project.model.Project;
import br.com.project.project.repository.ProjectRepository;

@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){

        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public void createProject(Project request){

        if (request.getName() == null || request.getName().isBlank()) throw new RuntimeException("Nome Inválido");
        if (request.getClassfication() == null) throw new RuntimeException("Classificação Inválida");
        if (request.getCode() == null || request.getCode().isBlank()) throw new RuntimeException("Código Inválido");
        if (request.getStartDate() == null) throw new RuntimeException("Data de Início Inválida");
        if (request.getEndDate().isBefore(request.getStartDate())) throw new RuntimeException("Data de Finalização Inválida");
        if (request.getDescription() == null || request.getDescription().isBlank()) throw new RuntimeException("Descrição Inválido");
        if (request.getStatus() == null) throw new RuntimeException("Status Inválido");

        projectRepository.save(request);
    }

    public Project getProjectById(Long id){
        if(id == null) throw new RuntimeException("id não válido");

        return projectRepository.findById(id)
        .orElseThrow(
            () -> new RuntimeException("Produto não encontrado")
        );
    }

    public void updateProjectById(Long id, Project update){
        if(id == null) throw new RuntimeException("id não válido");

        if (update.getName() == null || update.getName().isBlank()) throw new RuntimeException("Nome Inválido");
        if (update.getClassfication() == null) throw new RuntimeException("Classificação Inválida");
        if (update.getCode() == null || update.getCode().isBlank()) throw new RuntimeException("Código Inválido");
        if (update.getStartDate() == null) throw new RuntimeException("Data de Início Inválida");
        if (update.getEndDate().isBefore(update.getStartDate())) throw new RuntimeException("Data de Finalização Inválida");
        if (update.getDescription() == null || update.getDescription().isBlank()) throw new RuntimeException("Descrição Inválido");
        if (update.getStatus() == null) throw new RuntimeException("Status Inválido");

        Project project = projectRepository.findById(id)
        .orElseThrow(
            () -> new RuntimeException("Produto não encontrado")
        );

        project.setName(update.getName());
        project.setClassfication(update.getClassfication());
        project.setCode(update.getCode());
        project.setStartDate(update.getStartDate());
        project.setEndDate(update.getEndDate());
        project.setDescription(update.getDescription());
        project.setStatus(update.getStatus());

        projectRepository.save(project);
    }

    public void deleteProject(Long id){
        if(id == null) throw new RuntimeException("id não válido");

        this.getProjectById(id);
        projectRepository.deleteById(id);
    }
}
