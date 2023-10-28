package com.java.employeeservice.service;

import com.java.employeeservice.dto.APIResponseDto;
import com.java.employeeservice.dto.DepartmentDto;
import com.java.employeeservice.dto.EmployeeDto;
import com.java.employeeservice.dto.OrganizationDto;
import com.java.employeeservice.entity.Employee;
import com.java.employeeservice.feignclient.APIClient;
import com.java.employeeservice.mapper.EmployeeServiceMapper;
import com.java.employeeservice.repository.EmployeeRepository;
import com.java.employeeservice.service.impl.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private RestTemplate restTemplate;*/
    @Autowired
    private WebClient webClient;
    /*@Autowired
    APIClient apiClient;*/

    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeServiceMapper.dtoToEntity(employeeDto);
        Employee employee1=employeeRepository.save(employee);
        EmployeeDto employeeDto1=EmployeeServiceMapper.entityToDto(employee1);
        return employeeDto1;
    }

    @Override
    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long id) {
        LOGGER.info("Inside getEmployeeById() method");
        Employee employee=employeeRepository.findById(id).get();
      /*  ResponseEntity<DepartmentDto> response= restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto=response.getBody();*/

       DepartmentDto departmentDto=webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve().bodyToMono(DepartmentDto.class).block();

      OrganizationDto organizationDto=webClient.get().uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
               .retrieve()
               .bodyToMono(OrganizationDto.class).block();

        EmployeeDto employeeDto=EmployeeServiceMapper.entityToDto(employee);


        //DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode()).getBody();
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long id,Exception exception) {
        LOGGER.info("Inside getDefaultDepartment() method");
        Employee employee=employeeRepository.findById(id).get();

        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentName("R&D");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research & Development");

        EmployeeDto employeeDto=EmployeeServiceMapper.entityToDto(employee);


        //DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode()).getBody();
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
