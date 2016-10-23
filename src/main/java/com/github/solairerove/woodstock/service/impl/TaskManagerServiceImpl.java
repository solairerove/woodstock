package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Category;
import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.CategoryRepository;
import com.github.solairerove.woodstock.repository.TaskRepository;
import com.github.solairerove.woodstock.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TaskManagerServiceImpl implements TaskManagerService {

    private final TaskRepository taskRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public TaskManagerServiceImpl(TaskRepository taskRepository, CategoryRepository categoryRepository) {
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
        return null;
    }

    @Override
    public Iterable<Task> getAll(Long categoryId) {
        return null;
    }
}
