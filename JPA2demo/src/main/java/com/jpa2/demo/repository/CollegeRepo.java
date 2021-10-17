package com.jpa2.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa2.demo.repository.entity.College;

public interface CollegeRepo extends JpaRepository<College, Integer> {
	List<College> findByCollegeName(String name);
	
	//@Query(value = "select * from college_db.tbl_college", nativeQuery = true)
	@Query("select c from College c")
	List<College> displayCollege();
	
	@Query("select c from College c where c.collegeName= :cname")
	List<College> displayByName(@Param("cname")String name);
}
