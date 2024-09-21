package br.com.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
