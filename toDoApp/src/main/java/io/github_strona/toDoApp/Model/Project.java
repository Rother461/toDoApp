package io.github_strona.toDoApp.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name= "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @NotBlank(message = "tasks description must be not null")
    private String description;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> task_groups;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "project")
    private Set<ProjectStep> steps;

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

     Set<TaskGroup> getTask_groups() {
        return task_groups;
    }

     void setTask_groups(Set<TaskGroup> task_groups) {
        this.task_groups = task_groups;
    }

    public Set<ProjectStep> getSteps() {
        return steps;
    }

    public void setSteps(Set<ProjectStep> steps) {
        this.steps = steps;
    }
}
