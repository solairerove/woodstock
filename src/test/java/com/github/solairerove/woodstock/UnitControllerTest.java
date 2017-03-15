package com.github.solairerove.woodstock;

import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static com.github.solairerove.woodstock.controller.ControllerApi.UNIT_API;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UnitControllerTest {

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
    public void getAllPostsTest() throws Exception {
        repository.deleteAll();
        Unit unit = new Unit("Label", "URL to avatar", "Short MD description");
        repository.save(unit);

        mvc.perform(request(HttpMethod.GET, UNIT_API)
                .accept(APPLICATION_JSON_UTF8_VALUE)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].label", is("Label")))
                .andExpect(jsonPath("$.[0].avatar", is("URL to avatar")));
    }
}
