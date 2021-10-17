package com.jpa2.demo.primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.jpa2.demo.repository.entity.Department;

@Service("CommerceDepartment")
@Primary
public class CommerceDepartment implements DepartmentService {

	private static List<Department> list = new ArrayList<>();

	static {
		list.addAll(Arrays.asList(new Department(11, "Commerce", "Alvin", 15)));
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
