package com.java.departmentservice.mapper;

import com.java.departmentservice.dto.DepartmentDto;
import com.java.departmentservice.entity.Department;

public class DepartmentMapper {
    public static Department dtoToEntityMapper(DepartmentDto dto){
        Department department=new Department();
        department.setId(dto.getId());
        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentDescription(dto.getDepartmentDescription());
        department.setDepartmentCode(dto.getDepartmentCode());
        return department;
    }

    public static DepartmentDto entityToDtoMapper(Department department){
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        return departmentDto;
    }
}
