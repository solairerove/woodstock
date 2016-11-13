package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.common.GenericRepository;
import com.github.solairerove.woodstock.service.TaskService;
import com.github.solairerove.woodstock.service.common.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends GenericServiceImpl<Task> implements TaskService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public TaskServiceImpl(GenericRepository<Task> repository, ModuleRepository moduleRepository) {
        super(repository);
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
}
