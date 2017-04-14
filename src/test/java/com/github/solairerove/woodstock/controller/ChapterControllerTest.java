package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ChapterDTO;
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

import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by solairerove on 4/1/17.
 */
@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ChapterControllerTest {

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
    public void createChapterTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "Link to avatar", "Description");
        Module module = new Module("Name", "Avatar", "Description");
        Reference reference = new Reference("Title", "Version");

        module.addReference(reference);
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();
        String refId = reference.getId();

        ChapterDTO dto = new ChapterDTO("Chapter title", "Content");
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/" + moduleId +
                "/references/" + refId + "/chapters")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Chapter title")));
    }

    @Test
    public void getAllChaptersTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "Link to avatar", "Description");
        Module module = new Module("Name", "Avatar", "Description");
        Reference reference = new Reference("Title", "Version");
        Chapter chapter = new Chapter("Chapter title", "Content");

        reference.add(chapter);
        module.addReference(reference);
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();
        String refId = reference.getId();

        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId +
                "/references/" + refId + "/chapters")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[0].title", is("Chapter title")));
    }

    @Test
    public void getChapterTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "Link to avatar", "Description");
        Module module = new Module("Name", "Avatar", "Description");
        Reference reference = new Reference("Title", "Version");
        Chapter chapter = new Chapter("Chapter title", "Content");

        reference.add(chapter);
        module.addReference(reference);
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();
        String refId = reference.getId();
        String chapterId = chapter.getId();

        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId +
                "/references/" + refId + "/chapters/" + chapterId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Chapter title")));
    }
}
