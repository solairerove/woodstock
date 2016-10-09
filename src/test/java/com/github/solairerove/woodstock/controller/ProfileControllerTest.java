package com.github.solairerove.woodstock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.repository.ProfileRepository;
import com.github.solairerove.woodstock.utils.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Created by krivitski-no on 9/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class ProfileControllerTest {

    private static final String API_PATH = "/api/profiles";
    private static final String COLLECTION_JSON_PATH = "_embedded.profileList";

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ProfileRepository profileRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        profileRepository.deleteAll();
    }

    @Test
    public void getAllProfilesTest() throws Exception {
        profileRepository.save(EntityUtils.generateProfileCollection());

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$." + COLLECTION_JSON_PATH, hasSize(EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getProfileTest() throws Exception {
        Profile profile = EntityUtils.generateProfile();
        profileRepository.save(profile);
        String id = profile.getId();

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH + "/" + id)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(id)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void createProfileTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ProfileDTO profileDTO = EntityUtils.generateProfileDTO();

        mockMvc.perform(MockMvcRequestBuilders.post(API_PATH)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(profileDTO))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void updateProfileTest() throws Exception {
        Profile profile = EntityUtils.generateProfile();
        profileRepository.save(profile);
        String id = profile.getId();

        ObjectMapper objectMapper = new ObjectMapper();
        ProfileDTO profileDTO = EntityUtils.generateProfileDTO();

        mockMvc.perform(MockMvcRequestBuilders.put(API_PATH + "/" + id)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(profileDTO))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", is(id)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteProfileTest() throws Exception {
        Profile profile = EntityUtils.generateProfile();
        profileRepository.save(profile);
        String id = profile.getId();

        mockMvc.perform(MockMvcRequestBuilders.delete(API_PATH + "/" + id)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", is(id)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void deleteAllTest() throws Exception {
        profileRepository.save(EntityUtils.generateProfileCollection());

        mockMvc.perform(MockMvcRequestBuilders.delete(API_PATH + "/" + "delete_all")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}
