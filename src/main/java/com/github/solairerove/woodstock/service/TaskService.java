package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;

public interface TaskService {

    Task create(Long moduleId, TaskDTO taskDTO);

    Task get(Long moduleId, Long taskId);

    Iterable<Task> getAll(Long moduleId);
}
