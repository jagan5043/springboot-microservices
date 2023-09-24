package com.java.employeeservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
    private OrganizationDto organizationDto;
}
