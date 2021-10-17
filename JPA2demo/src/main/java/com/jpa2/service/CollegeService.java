package com.jpa2.service;

import java.util.List;
import java.util.Optional;

import com.jpa2.demo.repository.entity.College;
import com.jpa2.demo.repository.entity.Department;

public interface CollegeService {
	List<Department> getDepartment();
	College addCollege(College college);
	List<College> displayAll();
	Optional<College> getById(int id);
	List<College> getbyName(String name);
	College updateCollege(College college);
	String deletebyId(int id);
}
