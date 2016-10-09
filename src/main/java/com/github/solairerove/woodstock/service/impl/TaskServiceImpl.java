package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.service.TaskService;
import com.github.solairerove.woodstock.service.common.AbstractGenericService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 10/2/16.
 */
@Service
public class TaskServiceImpl extends AbstractGenericService<Task, TaskRepository, String>
        implements TaskService {

    public TaskServiceImpl(TaskRepository repo) {
        super(repo);
    }

    @Override
    public String update(String id, TaskDTO taskDTO) {
        Task task = repo.findOne(id);
        task.setQuestion(taskDTO.getQuestion());
        task.setUpdatedDate(LocalDateTime.now());
        repo.save(task);
        return id;
    }
}
