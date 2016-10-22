package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.repository.TaskRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.solairerove.woodstock.utils.EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTask;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTaskCollection;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateTaskDTO;
import static com.github.solairerove.woodstock.utils.EntityUtils.getRandomString;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Before
    public void setUp() {
        taskRepository.deleteAll();
    }

    @After
    public void clear() {
        taskRepository.deleteAll();
    }

    @Test
    public void createTaskTest() {
        TaskDTO saved = generateTaskDTO();
        Long id = taskService.create(saved).getId();

        assertEquals(saved.getQuestion(), taskRepository.findOne(id).getQuestion());
    }

    @Test
    public void getTaskTest() {
        Task saved = generateTask();
        taskRepository.save(saved);

        assertEquals(saved.getQuestion(), taskService.get(saved.getId()).getQuestion());
    }

    @Test
    public void updateTaskTest() {
        Task saved = generateTask();
        taskRepository.save(saved);
        Long id = saved.getId();

        TaskDTO ticketDTO = generateTaskDTO();
        String question = getRandomString();
        ticketDTO.setQuestion(question);

        taskService.update(id, ticketDTO);

        assertEquals(question, taskRepository.findOne(id).getQuestion());
    }

    @Test
    public void deleteTaskTest() {
        Task saved = generateTask();
        taskRepository.save(saved);
        Long id = saved.getId();

        taskService.delete(id);

        assertEquals(null, taskRepository.findOne(id));
    }

    @Test
    public void deleteAll() {
        taskRepository.save(generateTaskCollection());

        taskService.deleteAll();

        assertEquals(0, taskRepository.count());
    }

    @Test
    public void findAllTest() {
        taskRepository.save(generateTaskCollection());
        int count = NUMBER_OF_ENTITIES_IN_COLLECTION;

        assertEquals(count, taskService.findAll(new PageRequest(0, count)).getNumberOfElements());
    }
}
