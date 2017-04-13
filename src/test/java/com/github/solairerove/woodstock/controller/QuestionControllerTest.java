package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.QuestionDTO;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
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
    private UnitRepository repository;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();
    }

    @Test
    public void createQuestionTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        Module module = new Module("Name", "Link to avatar", "Short Description");
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();

        QuestionDTO dto = new QuestionDTO("Some Question");
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/" + moduleId + "/questions/")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.question", is("Some Question")));
    }

    @Test
    public void getQuestionTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        Module module = new Module("Name", "Link to avatar", "Short Description");
        Question question = new Question("What's up, bitch");

        module.addQuestion(question);
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();
        String questionId = question.getId();

        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/questions/" + questionId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.question", is("What's up, bitch")));
    }

    @Test
    public void getAllQuestionsTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        Module module = new Module("Name", "Link to avatar", "Short Description");
        Question question = new Question("What's up, bitch");

        module.addQuestion(question);
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();

        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/questions")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].question", is("What's up, bitch")));
    }
}
