package com.jpa2.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa2.demo.repository.CollegeRepo;
import com.jpa2.demo.repository.entity.College;
import com.jpa2.service.CollegeImpl;
import com.jpa2.service.CollegeService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testing {

	//@Autowired
	//private CollegeService service;
	
	@InjectMocks
	private CollegeImpl service;
	
	
	//@Autowired
	//@MockBean
	@Mock
	private CollegeRepo repo;
	
	@Test
	public void displayAllCollegeTest() {
		when(repo.findAll()).thenReturn(Stream.of(new College(1,"CANARA","Manglore",345),new College(2,"ALOYSIUS","MANGLORE",345)).collect(Collectors.toList()));
		assertEquals(2,service.displayAll().size());
	}
	
	
	/*
	@Test
	public void displayAllCollegeTest() {
		assertTrue(service.displayAll().size()>=0);
	}
	
	@Test
	public void addCollegeMethodTest() {
		College c=new College();
		c.setCollegeName("AAA");
		c.setAddress("Manglore");
		c.setTotalStudents(400);
		assertNotNull(service.addCollege(c));
	}
	
	@Test
	public void getByIDMethodTest() {
		Optional<College> c=Optional.ofNullable(new College());
		c=service.getById(2);
		assertEquals("AAA", c.get().getCollegeName());
	}
	
	
	@Test
	public void getByNameMethodTest() {
		List<College> list=new ArrayList<>();
		list=service.getbyName("AAA");
		assertTrue(list.size()>0);
	}
	*/
}
