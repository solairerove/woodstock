package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Answer;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.AnswerDTO;
import com.github.solairerove.woodstock.repository.AnswerRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.QuestionRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class AnswerControllerTest {

    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    private String unitId;

    private String moduleId;

    private String questionId;

    private String answerId;

    private AnswerDTO dto;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();
        // clean db
        unitRepository.deleteAll();
        moduleRepository.deleteAll();
        questionRepository.deleteAll();
        answerRepository.deleteAll();

        Answer answer = new Answer("Answer", true, true);
        Answer answer2 = new Answer("Answer2", true, true);
        answerRepository.save(Arrays.asList(answer, answer2));
        answerId = answer.getId();

        // init Reference
        Question question = new Question("Where's is my mind");
        question.add(answerId);
        question.add(answer2.getId());
        questionRepository.save(question);
        questionId = question.getId();

        // init Modules
        Module module = new Module("Name", "Link to avatar", "Short Description");
        module.addQuestion(questionId);
        moduleRepository.save(module);
        moduleId = module.getId();

        // init Unit
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        unit.add(moduleId);
        unitRepository.save(unit);
        unitId = unit.getId();

        // init ModuleDTO
        dto = new AnswerDTO("Cork", true, false);
    }

    @Test
    public void createAnswerTest() throws Exception {
        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/" + moduleId +
                "/questions/" + questionId + "/answers")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.answer", is("Cork")));

        assertEquals(3L, answerRepository.count());
    }

    @Test
    public void getAllAnswersTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId +
                "/questions/" + questionId + "/answers")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].answer", is("Answer")));

        assertEquals(2L, answerRepository.count());
    }

    @Test
    public void getAnswerTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId +
                "/questions/" + questionId + "/answers/" + answerId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.answer", is("Answer")));
    }

    @Test
    public void updateAnswerTest() throws Exception {
        mvc.perform(request(PUT, "/api/units/" + unitId + "/modules/" + moduleId +
                "/questions/" + questionId + "/answers/" + answerId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.answer", is("Cork")));

        assertEquals(2L, answerRepository.count());
        assertEquals(true, questionRepository.findOne(questionId).getAnswers().contains(answerId));
        assertEquals(2, questionRepository.findOne(questionId).getAnswers().size());
        assertEquals("Cork", answerRepository.findOne(answerId).getAnswer());
    }
}
