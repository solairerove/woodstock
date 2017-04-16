package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
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
public class ReferenceControllerTest {

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

    private String unitId;

    private String moduleId;

    private String refId;

    private ReferenceDTO dto;


    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();

        // clean db
        unitRepository.deleteAll();
        moduleRepository.deleteAll();
        referenceRepository.deleteAll();

        // init Reference
        Reference reference = new Reference("Reference Title", "Version");
        Reference reference2 = new Reference("Reference Title2", "Version2");
        referenceRepository.save(Arrays.asList(reference, reference2));
        refId = reference.getId();

        // init Modules
        Module module = new Module("Name", "Link to avatar", "Short Description");
        module.addReference(refId);
        module.addReference(reference2.getId());
        moduleRepository.save(module);
        moduleId = module.getId();

        // init Unit
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        unit.add(moduleId);
        unitRepository.save(unit);
        unitId = unit.getId();

        // init ModuleDTO
        dto = new ReferenceDTO("Cork", "v3");
    }

    @Test
    public void createReferenceTest() throws Exception {
        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/" + moduleId + "/references/")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Cork")))
                .andExpect(jsonPath("$.version", is("v3")));
    }

    @Test
    public void getReferenceTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/references/" + refId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Reference Title")));
    }

    @Test
    public void getAllReferencesTest() throws Exception {
        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/references")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Reference Title")));
    }

    @Test
    public void updateReferenceTest() throws Exception {
        mvc.perform(request(PUT, "/api/units/" + unitId + "/modules/" + moduleId + "/references/" + refId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Cork")))
                .andExpect(jsonPath("$.version", is("v3")));

        assertEquals(2L, referenceRepository.count());
        assertEquals(refId, referenceRepository.findOne(refId).getId());
        assertEquals(true, moduleRepository.findOne(moduleId).getReferences().contains(refId));
        assertEquals(2, moduleRepository.findOne(moduleId).getReferences().size());
    }
}
