package io.github_strona.toDoApp.adapter;

import io.github_strona.toDoApp.Model.Task;
import io.github_strona.toDoApp.Model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTaskrRepository extends TaskRepository, JpaRepository<Task,Integer> {
    @Override
    @Query(nativeQuery = true,value = "Select count(*)>0 from tasks where id=:id")
    boolean existsById(@Param("id")Integer id);
    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);
}
