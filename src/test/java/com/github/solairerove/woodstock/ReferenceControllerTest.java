package com.github.solairerove.woodstock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
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

/**
 * Created by solairerove on 3/29/17.
 */
@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ReferenceControllerTest {

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
    public void createReferenceTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        Module module = new Module("Name", "Link to avatar", "Short Description");
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();

        ReferenceDTO dto = new ReferenceDTO("Title", "Reference version");
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(request(POST, "/api/units/" + unitId + "/modules/" + moduleId + "/references/")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.version", is("Reference version")));
    }

    @Test
    public void getReferenceTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        Module module = new Module("Name", "Link to avatar", "Short Description");
        Reference reference = new Reference("Reference Title", "Version");

        module.addReference(reference);
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();
        String refId = reference.getId();

        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/references/" + refId)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title", is("Reference Title")));
    }

    @Test
    public void getAllReferencesTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        Module module = new Module("Name", "Link to avatar", "Short Description");
        Reference reference = new Reference("Reference Title", "Version");

        module.addReference(reference);
        unit.add(module);

        String unitId = repository.save(unit).getId();
        String moduleId = module.getId();

        mvc.perform(request(GET, "/api/units/" + unitId + "/modules/" + moduleId + "/references")
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Reference Title")));
    }
}
