package com.jpa2.demo.primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa2.demo.repository.entity.Department;

@Service("ScienceDepartment")
public class ScienceDepartment implements DepartmentService {

	private static List<Department> list = new ArrayList<>();

	static {
		list.addAll(Arrays.asList(new Department(12, "Science", "Hemanth", 20)));
	}

	@Override
	public List<Department> getDetails() {
		try {
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

}
