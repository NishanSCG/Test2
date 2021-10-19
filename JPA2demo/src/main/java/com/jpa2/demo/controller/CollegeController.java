package com.jpa2.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa2.demo.mapper.CollegeMapperImpl;
import com.jpa2.demo.repository.dto.CollegeDto;
import com.jpa2.demo.repository.entity.College;
import com.jpa2.demo.repository.entity.Department;
import com.jpa2.service.CollegeService;

@RestController
@RequestMapping("api.collegeexample.com")
public class CollegeController {
	// Nishan siriyan
	// Manoj Kumar
	// Nihal Kunder

	// Nishan siriyan
	// Manoj Kumar
	// Nihal Kunder

	@Autowired
	private CollegeMapperImpl mapperClass;

	@Lazy
	@Autowired
	private CollegeService service;

	@PostMapping
	public ResponseEntity<CollegeDto> create(@RequestBody final College college) {
		final College save = service.addCollege(college);
		return new ResponseEntity<>(mapperClass.toCollegeDto(save), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CollegeDto>> retrieveAll() {
		final List<College> findAll = service.displayAll();
		return ResponseEntity.ok(mapperClass.entityToDto(findAll));
	}

	@GetMapping("{id}")
	public ResponseEntity<CollegeDto> readById(@PathVariable final int id) {
		final Optional<College> collegeOpt = service.getById(id);
		if (collegeOpt.isPresent()) {
			return ResponseEntity.ok(mapperClass.toCollegeDto(collegeOpt.get()));
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("college-name")
	public ResponseEntity<List<CollegeDto>> readByName(@RequestParam final String name) {
		final List<College> finadAll = service.getbyName(name);
		return ResponseEntity.ok(mapperClass.entityToDto(finadAll));
	}

	@PutMapping
	public ResponseEntity<CollegeDto> update(@RequestBody final College college) {
		final College save = service.updateCollege(college);
		return new ResponseEntity<>(mapperClass.toCollegeDto(save), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable final int id) {
		return ResponseEntity.ok(service.deletebyId(id));
	}

	@GetMapping("department")
	public ResponseEntity<List<Department>> retrieveDepartment() {
		return ResponseEntity.ok(service.getDepartment());
	}

}
