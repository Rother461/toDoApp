package io.github_strona.toDoApp.adapter;

import io.github_strona.toDoApp.Model.Project;
import io.github_strona.toDoApp.Model.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends JpaRepository<Project, Integer>, ProjectRepository {

    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();


}
