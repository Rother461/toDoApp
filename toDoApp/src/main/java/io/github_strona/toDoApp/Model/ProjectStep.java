package io.github_strona.toDoApp.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="projects_steps")
public class ProjectStep {
    @ManyToOne
    @JoinColumn(name= "project_id")
    private Project project;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @NotBlank(message = "project step description must be not null")
    private String description;
    private int daysToDeadline;

    public Project getProject() {
        return project;
    }

     void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

     void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

     void setDescription(String description) {
        this.description = description;
    }

    public int getDaysToDeadline() {
        return daysToDeadline;
    }

     void setDaysToDeadline(int daysToDeadline) {
        this.daysToDeadline = daysToDeadline;
    }
}
