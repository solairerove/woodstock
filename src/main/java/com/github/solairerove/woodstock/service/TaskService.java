package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.service.common.GenericService;

public interface TaskService extends GenericService<Task> {

    Task create(Long moduleId, TaskDTO taskDTO);
}
