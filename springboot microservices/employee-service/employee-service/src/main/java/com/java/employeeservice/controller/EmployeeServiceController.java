package com.java.employeeservice.controller;

import com.java.employeeservice.dto.APIResponseDto;
import com.java.employeeservice.dto.EmployeeDto;
import com.java.employeeservice.service.impl.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Employee Service - Employee Controller",
        description = "Employee Service - Employee Controller exposes Rest APIs for Employee Service"
)
@RestController
@RequestMapping("/api/employees")
public class EmployeeServiceController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("")
    @ApiResponse(
            responseCode = "201",
            description = "Employee Object Saved Successfully"
    )
    @Operation(
            summary = "SAVE Employee API",
            description = "SAVE Employee APi is used to SAVE Employee Object in database"
    )
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto dto=employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiResponse(
            responseCode = "200",
            description = "Fetched successfully"
    )
    @Operation(
            summary = "GET Employee API",
            description = "GET Employee API is used to fetch Employee Object from database"
    )
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long id){
        APIResponseDto apiResponseDto= employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
