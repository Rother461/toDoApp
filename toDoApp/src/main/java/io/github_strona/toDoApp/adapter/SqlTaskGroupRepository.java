package io.github_strona.toDoApp.adapter;

import io.github_strona.toDoApp.Model.TaskGroup;
import io.github_strona.toDoApp.Model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlTaskGroupRepository extends JpaRepository<TaskGroup, Integer>, TaskGroupRepository {

    @Override
    @Query("select distinct g from TaskGroup g join fetch g.tasks")
    List<TaskGroup> findAll();

    @Override
    boolean  existsByDoneIsFalseAndProject_Id(Integer projectId);
}
