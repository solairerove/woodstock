package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ModuleRepository moduleRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ModuleRepository moduleRepository) {
        this.taskRepository = taskRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Task create(Long moduleId, TaskDTO taskDTO) {
        Task task = new Task();
        task.setQuestion(taskDTO.getQuestion());

        Module module = moduleRepository.findOne(moduleId);
        module.getTasks().add(task);
        moduleRepository.save(module);

        return task;
    }

    @Override
    public Task get(Long moduleId, Long taskId) {
        return taskRepository.getTaskThatHasInModuleFromId(moduleId, taskId);
    }

    @Override
    public Iterable<Task> getAll(Long moduleId) {
        return taskRepository.getTasksThatHasInModuleFromId(moduleId);
    }
}
