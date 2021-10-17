package com.jpa2.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.jpa2.demo.repository.dto.CollegeDto;
import com.jpa2.demo.repository.entity.College;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollegeMapper {

	CollegeDto toCollegeDto(College college);
	
	College toCollege(CollegeDto collegeDto);
	
	List<CollegeDto> entityToDto(List<College> college);
	
	List<College>DtoToEntity(List<CollegeDto> collegeDto);
}
