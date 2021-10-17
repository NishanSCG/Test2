package com.jpa2.demo.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	private int deptId;
	private String depName;
	private String hod;
	private int totalFaculty;

}
