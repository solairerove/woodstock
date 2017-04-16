package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.repository.ChapterRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.ReferenceRepository;
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
public class ChapterControllerTest {

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
    private ReferenceRepository referenceRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    private String unitId;

    private String moduleId;

    private String refId;

    private String chapterId;

    private ChapterDTO dto;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();
        // clean db
        unitRepository.deleteAll();
        moduleRepository.deleteAll();
        referenceRepository.deleteAll();
        chapterRepository.deleteAll();

        Chapter chapter = new Chapter("Title", "Content");
        Chapter chapter2 = new Chapter("Title", "Content");
        chapterRepository.save(Arrays.asList(chapter, chapter2));
        chapterId = chapter.getId();

        // init Reference
        Reference reference = new Reference("Reference Title", "Version");
        reference.add(chapterId);
        reference.add(chapter2.getId());
        referenceRepository.save(reference);
        refId = reference.getId();

        // init Modules
        Module module = new Module("Name", "Link to avatar", "Short Description");
        module.addReference(refId);
        moduleRepository.save(module);
        moduleId = module.getId();

        // init Unit
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        unit.add(moduleId);
        unitRepository.save(unit);
        unitId = unit.getId();

        // init ModuleDTO
        dto = new ChapterDTO("Cork", "Ireland");
    }

    @Test
    public void createChapterTest() throws Exception {
        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/" + moduleId +
                "/references/" + refId + "/chapters")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Cork")));

        assertEquals(3L, chapterRepository.count());
    }

    @Test
    public void getAllChaptersTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId +
                "/references/" + refId + "/chapters")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].title", is("Title")));

        assertEquals(2L, chapterRepository.count());
    }

    @Test
    public void getChapterTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId +
                "/references/" + refId + "/chapters/" + chapterId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Title")));
    }

    @Test
    public void updateChapterTest() throws Exception {
        mvc.perform(request(PUT, "/api/units/" + unitId + "/modules/" + moduleId +
                "/references/" + refId + "/chapters/" + chapterId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Cork")))
                .andExpect(jsonPath("$.content", is("Ireland")));

        assertEquals(2L, chapterRepository.count());
        assertEquals(true, referenceRepository.findOne(refId).getChapters().contains(chapterId));
        assertEquals(2, referenceRepository.findOne(refId).getChapters().size());
        assertEquals("Cork", chapterRepository.findOne(chapterId).getTitle());
    }
}
