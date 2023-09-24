package com.java.employeeservice.mapper;

import com.java.employeeservice.dto.EmployeeDto;
import com.java.employeeservice.entity.Employee;

public class EmployeeServiceMapper {
    public static EmployeeDto entityToDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartmentCode(employee.getDepartmentCode());
        employeeDto.setOrganizationCode(employee.getOrganizationCode());
        return employeeDto;
    }

    public static Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee=new Employee();
        //employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());
        employee.setOrganizationCode(employeeDto.getOrganizationCode());
        return employee;
    }
}
