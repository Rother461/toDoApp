package io.github_strona.toDoApp.Model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task>findAll();
    Optional<Task> findById(Integer id);
    boolean existsById(Integer id);
    Task save(Task entity);
    List<Task> findByDone(@Param("state")boolean done);
    Page<Task> findAll(Pageable page);
   boolean  existsByDoneIsFalseAndGroup_Id(Integer groupId);
}
