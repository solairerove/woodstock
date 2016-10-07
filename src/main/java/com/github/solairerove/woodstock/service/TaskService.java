package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by krivitski-no on 10/2/16.
 */
public interface TaskService {
    String createTask(TaskDTO taskDTO);

    Task getTask(String id);

    String updateTask(String id, TaskDTO taskDTO);

    String deleteTask(String id);

    List<Task> deleteAll();

    Page<Task> findAll(Pageable pageable);
}
