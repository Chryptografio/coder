package ru.croc.coder.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * todo Document type ProblemServiceTest
 */
@SpringBootTest
public class SolutionServiceTest {
    @Autowired
    private WebApplicationContext applicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void publishProblem() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
            .post("/users/4/problems/7/solutions")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
            "    \"code\": \"helloworld\"\n" +
            "}"))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
