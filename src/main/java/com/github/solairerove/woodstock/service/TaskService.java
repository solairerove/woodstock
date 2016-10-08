package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.service.common.GenericService;

/**
 * Created by krivitski-no on 10/2/16.
 */
public interface TaskService extends GenericService<Task, String> {
    String create(TaskDTO taskDTO);

    String update(String id, TaskDTO taskDTO);
}
