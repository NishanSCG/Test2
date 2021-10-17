package com.jpa2.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.jpa2.demo.mapper.CollegeMapperImpl;
import com.jpa2.demo.primary.DepartmentService;
import com.jpa2.demo.repository.CollegeRepo;
import com.jpa2.demo.repository.entity.College;
import com.jpa2.demo.repository.entity.Department;

import java.util.Optional;

@Lazy
@Service
public class CollegeImpl implements CollegeService{
	@Autowired
	private CollegeRepo repo;
	@Qualifier("ScienceDepartment")
	@Autowired
	public DepartmentService dept;

	@Override
	public List<Department> getDepartment() {
		try {
			return dept.getDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public College addCollege(College college) {
		try {
			return repo.save(college);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<College> displayAll() {
		try {
			
			return repo.displayCollege();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public Optional<College> getById(int id) {
		try {
			return repo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	@Override
	public List<College> getbyName(String name) {
		try {
			//return repo.findByCollegeName(name);
			return repo.displayByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public College updateCollege(College college) {
		try {
			
			College college2 = repo.findById(college.getCollegeId()).orElse(null);
			college2.setCollegeName(college.getCollegeName());
			college2.setAddress(college.getAddress());
			college2.setTotalStudents(college.getTotalStudents());
			return repo.save(college2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deletebyId(int id) {
		try {
			repo.deleteById(id);
			return "deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
