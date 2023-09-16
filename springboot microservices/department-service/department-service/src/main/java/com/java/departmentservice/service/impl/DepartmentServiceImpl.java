package com.java.departmentservice.service.impl;

import com.java.departmentservice.dto.DepartmentDto;
import com.java.departmentservice.entity.Department;
import com.java.departmentservice.mapper.DepartmentMapper;
import com.java.departmentservice.repository.DepartmentRepository;
import com.java.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department=DepartmentMapper.dtoToEntityMapper(departmentDto);
        Department department1=departmentRepository.save(department);
        return DepartmentMapper.entityToDtoMapper(department1);
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode).get();
        return DepartmentMapper.entityToDtoMapper(department);
    }
}
