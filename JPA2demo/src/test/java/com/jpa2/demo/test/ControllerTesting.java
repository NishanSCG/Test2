package com.jpa2.demo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jpa2.demo.controller.CollegeController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTesting {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private CollegeController controller;
	
	@Before
	public void setup() {
		mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	/*
	@Test
	public void testCreateMethod() throws Exception {
		mockMvc.perform(post("/api.collegeexample.com")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n"
						+ "       \"collegeName\":\"MANGALA COLLEGE\",\n"
						+ "       \"address\":\"MANGALORE\",\n"
						+ "       \"totalStudents\":789\n"
						+ "    }"))
				.andExpect(status().isOk());	
	}
	*/
	
	@Test
	public void testReadByIdMethod() throws Exception {
		mockMvc.perform(get("/api.collegeexample.com"))
		.andExpect(status().isOk());
				
	}
	
	@Test
	public void testreadByIdMethod() {
		
	}
	
}
