//package com.github.solairerove.woodstock.service;
//
//import com.github.solairerove.woodstock.Application;
//import com.github.solairerove.woodstock.domain.Task;
//import com.github.solairerove.woodstock.dto.TaskDTO;
//import com.github.solairerove.woodstock.repository.TaskRepository;
//import com.github.solairerove.woodstock.utils.EntityUtils;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Created by krivitski-no on 10/2/16.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//public class TaskServiceTest {
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @Before
//    public void setUp() {
//        taskRepository.deleteAll();
//    }
//
//    @Test
//    public void createTaskTest() {
//        TaskDTO saved = EntityUtils.generateTaskDTO();
//        String id = taskService.create(saved).getId();
//
//        Assert.assertEquals(saved.getQuestion(), taskRepository.findOne(id).getQuestion());
//    }
//
//    @Test
//    public void getTaskTest() {
//        Task saved = EntityUtils.generateTask();
//        taskRepository.save(saved);
//
//        Assert.assertEquals(saved.getQuestion(), taskService.get(saved.getId()).getQuestion());
//    }
//
//    @Test
//    public void updateTaskTest() {
//        Task saved = EntityUtils.generateTask();
//        taskRepository.save(saved);
//        String id = saved.getId();
//
//        TaskDTO ticketDTO = EntityUtils.generateTaskDTO();
//        String question = EntityUtils.getRandomString();
//        ticketDTO.setQuestion(question);
//
//        taskService.update(id, ticketDTO);
//
//        Assert.assertEquals(question, taskRepository.findOne(id).getQuestion());
//    }
//
//    @Test
//    public void deleteTaskTest() {
//        Task saved = EntityUtils.generateTask();
//        taskRepository.save(saved);
//        String id = saved.getId();
//
//        taskService.delete(id);
//
//        Assert.assertEquals(null, taskRepository.findOne(id));
//    }
//
//    @Test
//    public void deleteAll() {
//        taskRepository.save(EntityUtils.generateTaskCollection());
//
//        taskService.deleteAll();
//
//        Assert.assertEquals(0, taskRepository.count());
//    }
//
//    @Test
//    public void findAllTest() {
//        taskRepository.save(EntityUtils.generateTaskCollection());
//        int count = EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;
//
//        Assert.assertEquals(count, taskService.findAll(new PageRequest(0, count)).getTotalElements());
//    }
//}
