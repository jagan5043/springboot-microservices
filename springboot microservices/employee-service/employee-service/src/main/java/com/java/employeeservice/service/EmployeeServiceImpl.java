package com.java.employeeservice.service;

import com.java.employeeservice.dto.APIResponseDto;
import com.java.employeeservice.dto.DepartmentDto;
import com.java.employeeservice.dto.EmployeeDto;
import com.java.employeeservice.entity.Employee;
import com.java.employeeservice.feignclient.APIClient;
import com.java.employeeservice.mapper.EmployeeServiceMapper;
import com.java.employeeservice.repository.EmployeeRepository;
import com.java.employeeservice.service.impl.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
  /*  @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;*/
    @Autowired
    APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeServiceMapper.dtoToEntity(employeeDto);
        Employee employee1=employeeRepository.save(employee);
        EmployeeDto employeeDto1=EmployeeServiceMapper.entityToDto(employee1);
        return employeeDto1;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).get();
      /*  ResponseEntity<DepartmentDto> response= restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto=response.getBody();*/

       /* DepartmentDto departmentDto=webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve().bodyToMono(DepartmentDto.class).block();
                
        */
        EmployeeDto employeeDto=EmployeeServiceMapper.entityToDto(employee);


        DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode()).getBody();
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
