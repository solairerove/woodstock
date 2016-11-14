package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.service.TaskService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.solairerove.woodstock.service.common.ModelMapper.convertToTask;

@Service
public class TaskServiceImpl extends GenericServiceImpl<Task, TaskRepository> implements TaskService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository, ModuleRepository moduleRepository) {
        super(repository);
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Task create(Long moduleId, TaskDTO taskDTO) {
        Task task = convertToTask(taskDTO);

        Module module = moduleRepository.findOne(moduleId);
        module.getTasks().add(task);
        moduleRepository.save(module);

        return task;
    }
}
