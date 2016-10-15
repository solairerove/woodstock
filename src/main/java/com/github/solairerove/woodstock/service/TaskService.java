package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by krivitski-no on 10/2/16.
 */
public interface TaskService {

    Task create(TaskDTO taskDTO);

    Task get(Long id);

    Page<Task> findAll(Pageable pageable);

    Task update(Long id, TaskDTO taskDTO);

    Long delete(Long id);

    Iterable<Task> deleteAll();
}
