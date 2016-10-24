package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.CategoryRepository;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Task create(Long categoryId, TaskDTO taskDTO) {
        Task task = new Task();
        task.setQuestion(taskDTO.getQuestion());
        task.setCreatedDate(LocalDateTime.now().toString());

        Category category = categoryRepository.findOne(categoryId);
        category.getTasks().add(task);
        category.setUpdatedDate(LocalDateTime.now().toString());
        categoryRepository.save(category);

        return task;
    }

    @Override
    public Task get(Long categoryId, Long taskId) {
        return taskRepository.getTaskThatHasInCategoryFromId(categoryId, taskId);
    }

    @Override
    public Iterable<Task> getAll(Long categoryId) {
        return taskRepository.getTasksThatHasInCategoryFromId(categoryId);
    }

    @Override
    public Iterable<Task> deleteAll() {
        Iterable<Task> tasks = taskRepository.findAll();
        taskRepository.deleteAll();
        return tasks;
    }
}
