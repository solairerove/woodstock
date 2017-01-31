//package com.github.solairerove.woodstock.service.impl;
//
//import com.github.solairerove.woodstock.domain.Module;
//import com.github.solairerove.woodstock.domain.Task;
//import com.github.solairerove.woodstock.dto.TaskDTO;
//import com.github.solairerove.woodstock.repository.ModuleRepository;
//import com.github.solairerove.woodstock.repository.TaskRepository;
//import com.github.solairerove.woodstock.service.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import static com.github.solairerove.woodstock.service.mapper.ModelMapper.convertToTask;
//
//@Service
//public class TaskServiceImpl implements TaskService {
//
//    private final ModuleRepository moduleRepository;
//
//    private final TaskRepository taskRepository;
//
//    @Autowired
//    public TaskServiceImpl(ModuleRepository moduleRepository, TaskRepository taskRepository) {
//        this.moduleRepository = moduleRepository;
//        this.taskRepository = taskRepository;
//    }
//
//    @Override
//    public Task create(Long moduleId, TaskDTO taskDTO) {
//        Task task = convertToTask(taskDTO);
//
//        Module module = moduleRepository.findOne(moduleId);
//        module.getTasks().add(task);
//        moduleRepository.save(module);
//
//        return task;
//    }
//
//    @Override
//    public Task get(Long moduleId, Long taskId) {
//        return taskRepository.getOneThatHasInNode(moduleId, taskId);
//    }
//
//    @Override
//    public Iterable<Task> getAll(Long moduleId) {
//        return taskRepository.getAllThatHasInNode(moduleId);
//    }
//
//    @Override
//    public Task update(Long moduleId, Long taskId, TaskDTO taskDTO) {
//        Task task = taskRepository.getOneThatHasInNode(moduleId, taskId);
//        task.setQuestion(taskDTO.getQuestion());
//
//        return taskRepository.save(task);
//    }
//
//    @Override
//    public Task delete(Long moduleId, Long taskId) {
//        Task task = taskRepository.getOneThatHasInNode(moduleId, taskId);
//        taskRepository.deleteOneThatHasInNode(moduleId, taskId);
//
//        return task;
//    }
//}
