package io.github_strona.toDoApp.logic;


import io.github_strona.toDoApp.Model.TaskGroup;
import io.github_strona.toDoApp.Model.TaskGroupRepository;
import io.github_strona.toDoApp.Model.TaskRepository;
import io.github_strona.toDoApp.Model.projection.GroupReadModel;
import io.github_strona.toDoApp.Model.projection.GroupWriteModel;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequestScope
public class TaskGroupService {
    private TaskGroupRepository repository;
    private TaskRepository taskRepository;


    public TaskGroupService(TaskGroupRepository repository, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;

    }

    public TaskGroupService(TaskGroupRepository repository) {
        this.repository = repository;
    }

    public GroupReadModel createGroup(GroupWriteModel source) {
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId) {
        if (taskRepository.existsByDoneIsFalseAndGroup_Id(groupId))
        {
            throw new IllegalStateException("Group has undone task. Done all the tasks first");
        }
        TaskGroup result = repository.findById(groupId)
                .orElseThrow(()-> new IllegalArgumentException("Task group with given id not found"));
        result.setDone(!result.isDone());
    }


}
