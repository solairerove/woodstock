package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.BaseEntity;
import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 10/2/16.
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public String createTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getQuestion());
        task.setCreatedDate(LocalDateTime.now());
        taskRepository.save(task);
        return task.getId();
    }

    public Task getTask(String id) {
        return taskRepository.findOne(id);
    }

    public String updateTask(String id, TaskDTO taskDTO) {
        if (taskRepository.exists(id)) {
            Task task = taskRepository.findOne(id);
            task.setQuestion(taskDTO.getQuestion());
            task.setUpdatedDate(LocalDateTime.now());
            taskRepository.save(task);
        }
        return id;
    }

    public String deleteTask(String id) {
        taskRepository.delete(id);
        return id;
    }

    public Iterable<? extends BaseEntity> deleteAll() {
        Iterable<? extends Task> tickets = taskRepository.findAll();
        taskRepository.deleteAll();
        return tickets;
    }

    public Page<Task> findAll(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }
}
