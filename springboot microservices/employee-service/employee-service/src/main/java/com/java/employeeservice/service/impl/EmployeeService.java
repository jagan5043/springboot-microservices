package com.java.employeeservice.service.impl;

import com.java.employeeservice.dto.APIResponseDto;
import com.java.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public APIResponseDto getEmployeeById(Long id);
}
