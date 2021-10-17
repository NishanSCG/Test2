package com.JPA2.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jpa2.demo.repository.CollegeRepo;
import com.jpa2.demo.repository.entity.College;
import com.jpa2.service.CollegeImpl;
import com.jpa2.service.CollegeService;



class Jpa2demoApplicationTests {

	@Autowired
	private CollegeImpl service;
	
	@Autowired
	@MockBean
	private CollegeRepo repo;
	
	@Test
	public void displayAllCollegeTest() {
		//when(repo.findAll()).thenReturn(Stream.of(new College(1,"CANARA","Manglore",345),new College(2,"ALOYSIUS","MANGLORE",345)).collect(Collectors.toList()));
		assertNotNull(service.displayAll().size());
		
	}
	
	

	
}
