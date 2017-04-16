package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
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
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by solairerove on 3/27/17.
 */
@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ModuleControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    private Unit unit;

    private String unitId;

    private String moduleid;

    private ModuleDTO moduleDTO;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();

        unitRepository.deleteAll();
        moduleRepository.deleteAll();

        unit = new Unit("Label", "URL to avatar", "Short MD description");
        unitId = unitRepository.save(unit).getId();

        moduleDTO = new ModuleDTO("Cork", "Link to avatar", "Short description");
    }

    @Test
    public void createModuleTest() throws Exception {

        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(moduleDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name", is("Cork")))
                .andExpect(jsonPath("$.avatar", is("Link to avatar")));

        assertEquals(1L, moduleRepository.count());
        assertEquals(1, unitRepository.findOne(unitId).getModules().size());
    }

//    @Test
//    public void getModuleTest() throws Exception {
//        repository.deleteAll();
//        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
//        Module module = new Module("Name", "Link to avatar", "Short Description");
//        unit.add(module);
//
//        String unitId = repository.save(unit).getId();
//        String moduleId = module.getId();
//
//        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId)
//                .accept(APPLICATION_JSON_UTF8_VALUE)
//                .contentType(APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$.name", is("Name")))
//                .andExpect(jsonPath("$.avatar", is("Link to avatar")));
//    }
//
//    @Test
//    public void getAllModulesTest() throws Exception {
//        repository.deleteAll();
//        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
//        Module module = new Module("Name", "Link to avatar", "Short Description");
//        Module module2 = new Module("Name2", "Link to avatar2", "Short Description");
//        unit.add(module);
//        unit.add(module2);
//
//        String unitId = repository.save(unit).getId();
//
//        mvc.perform(request(GET, "/api/units/" + unitId + "/modules")
//                .accept(APPLICATION_JSON_UTF8_VALUE)
//                .contentType(APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$.[0].name", is("Name")))
//                .andExpect(jsonPath("$.[0].avatar", is("Link to avatar")))
//                .andExpect(jsonPath("$.[1].name", is("Name2")))
//                .andExpect(jsonPath("$.[1].avatar", is("Link to avatar2")));
//    }

    @Test
    public void updateModuleTest() throws Exception {
        Module module = new Module("Name", "Link to avatar", "Short Description");
        Module module2 = new Module("Name2", "Link to avatar2", "Short Description");

        moduleRepository.save(Arrays.asList(module, module2));

        String moduleId = module.getId();
        String moduleId2 = module2.getId();
        unit.add(moduleId);
        unit.add(moduleId2);
        unitRepository.save(unit);

        mvc.perform(request(PUT, "/api/units/" + unitId + "/modules/" + moduleId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(mapper.writeValueAsString(moduleDTO)))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name", is("Cork")));

        assertEquals(2, unitRepository.findOne(unitId).getModules().size());
        assertEquals(moduleId, unitRepository.findOne(unitId).getModules().get(1));
        assertEquals(moduleId, moduleRepository.findOne(moduleId).getId());
    }

//    @Test
//    public void deleteModuleTest() throws Exception {
//        repository.deleteAll();
//        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
//        Module module = new Module("Name", "Link to avatar", "Short Description");
//        Module module2 = new Module("Name2", "Link to avatar2", "Short Description");
//        unit.add(module);
//        unit.add(module2);
//
//        String unitId = repository.save(unit).getId();
//        String moduleId = module.getId();
//
//        mvc.perform(request(DELETE, "/api/units/" + unitId + "/modules/" + moduleId)
//                .accept(APPLICATION_JSON_UTF8_VALUE)
//                .contentType(APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isAccepted())
//                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$.name", is("Name")));
//
//        assertEquals(1, repository.findOne(unitId).getModules().size());
//        assertEquals("Name2", repository.findOne(unitId).getModules().get(0).getName());
//    }
}
