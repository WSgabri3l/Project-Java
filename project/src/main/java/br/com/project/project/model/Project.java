package br.com.project.project.model;

import java.time.LocalDate;

import br.com.project.project.model.enums.Classification;
import br.com.project.project.model.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Classification classfication;
    private String code;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Project(Long id, String name, Classification classfication, String code, LocalDate startDate,
            LocalDate endDate, String description, Status status) {
            this.id = id;
            this.name = name;
            this.classfication = classfication;
            this.code = code;
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
            this.status = status;
    }

    //Exigência do Spring para um processo interno de busca.
    public Project() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Classification getClassfication() {
        return classfication;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassfication(Classification classfication) {
        this.classfication = classfication;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    
    
}
