package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;

public interface TaskManagerService {

    Task create(Long categoryId, TaskDTO taskDTO);

    Task get(Long categoryId, Long taskId);

    Iterable<Task> getAll(Long categoryId);
}
