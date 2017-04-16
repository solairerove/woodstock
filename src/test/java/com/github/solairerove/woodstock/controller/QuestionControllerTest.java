package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.QuestionDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.QuestionRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionControllerTest {

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

    private String unitId;

    private String moduleId;

    private String questionId;

    private QuestionDTO dto;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();

        // clean db
        unitRepository.deleteAll();
        moduleRepository.deleteAll();
        questionRepository.deleteAll();

        // init Question
        Question question = new Question("What's up, bitch");
        Question question2 = new Question("Question");
        questionRepository.save(Arrays.asList(question, question2));
        questionId = question.getId();

        // init Modules
        Module module = new Module("Name", "Link to avatar", "Short Description");
        module.addQuestion(questionId);
        module.addQuestion(question2.getId());
        moduleRepository.save(module);
        moduleId = module.getId();

        // init Unit
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        unit.add(moduleId);
        unitRepository.save(unit);
        unitId = unit.getId();

        // init QuestionDTO
        dto = new QuestionDTO("Is Cork one of the cities in Ireland");
    }

    @Test
    public void createQuestionTest() throws Exception {
        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/" + moduleId + "/questions/")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.question", is("Is Cork one of the cities in Ireland")));

        assertEquals(3L, questionRepository.count());
    }

    @Test
    public void getQuestionTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/questions/" + questionId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.question", is("What's up, bitch")));
    }

    @Test
    public void getAllQuestionsTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/questions")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].question", is("What's up, bitch")));
    }

    @Test
    public void updateQuestionTest() throws Exception {
        mvc.perform(request(PUT, "/api/units/" + unitId + "/modules/" + moduleId + "/questions/" + questionId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.question", is("Is Cork one of the cities in Ireland")));

        assertEquals(2L, questionRepository.count());
        assertEquals(true, moduleRepository.findOne(moduleId).getQuestions().contains(questionId));
        assertEquals(2, moduleRepository.findOne(moduleId).getQuestions().size());
        assertEquals("Is Cork one of the cities in Ireland", questionRepository.findOne(questionId).getQuestion());
    }
}
