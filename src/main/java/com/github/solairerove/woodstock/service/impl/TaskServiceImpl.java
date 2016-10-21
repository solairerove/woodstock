package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task create(TaskDTO taskDTO) {
        Task task = new Task();
        task.setQuestion(taskDTO.getQuestion());
        task.setCreatedDate(LocalDateTime.now().toString());
        return repository.save(task);
    }

    @Override
    public Task get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Task update(Long id, TaskDTO taskDTO) {
        Task task = repository.findOne(id);
        task.setQuestion(taskDTO.getQuestion());
        task.setUpdatedDate(LocalDateTime.now().toString());
        return repository.save(task);
    }

    @Override
    public Long delete(Long id) {
        repository.delete(id);
        return id;
    }

    @Override
    public Iterable<Task> deleteAll() {
        Iterable<Task> tasks = repository.findAll();
        repository.deleteAll();
        return tasks;
    }
}
