//package com.github.solairerove.woodstock.service.impl;
//
//import com.github.solairerove.woodstock.domain.Task;
//import com.github.solairerove.woodstock.dto.TaskDTO;
//import com.github.solairerove.woodstock.repository.TaskRepository;
//import com.github.solairerove.woodstock.service.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
///**
// * Created by krivitski-no on 10/2/16.
// */
//@Service
//public class TaskServiceImpl implements TaskService {
//
//    private final TaskRepository repository;
//
//    @Autowired
//    public TaskServiceImpl(TaskRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public Task create(TaskDTO taskDTO) {
//        Task task = new Task(taskDTO.getQuestion());
//        task.setCreatedDate(LocalDateTime.now().toString());
//        return repository.save(task);
//    }
//
//    @Override
//    public Task get(String id) {
//        return repository.findOne(id);
//    }
//
//    @Override
//    public Page<Task> findAll(Pageable pageable) {
//        return repository.findAll(pageable);
//    }
//
//    @Override
//    public Task update(String id, TaskDTO taskDTO) {
//        Task task = repository.findOne(id);
//        task.setQuestion(taskDTO.getQuestion());
//        task.setUpdatedDate(LocalDateTime.now().toString());
//        return repository.save(task);
//    }
//
//    @Override
//    public String delete(String id) {
//        repository.delete(id);
//        return id;
//    }
//
//    @Override
//    public List<Task> deleteAll() {
//        List<Task> tasks = repository.findAll();
//        repository.deleteAll();
//        return tasks;
//    }
//}
