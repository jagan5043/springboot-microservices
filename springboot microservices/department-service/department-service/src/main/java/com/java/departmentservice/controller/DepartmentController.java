package com.java.departmentservice.controller;

import com.java.departmentservice.dto.DepartmentDto;
import com.java.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Department Service - Department Controller",
        description = "Department Controller exposes Rest APIs for Department Service"
)
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService;
    @PostMapping("")
    @Operation(
            summary = "Save Department Rest API",
            description = "Save Department  REST API is used to save Department Object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto dto=departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @Operation(
            summary = "GET Department Rest API",
            description = "GET Department  REST API is used to fetch Department Object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 FETCHED successfully"
    )
    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentCode") String departmentCode){
        DepartmentDto departmentDto=departmentService.getDepartment(departmentCode);
       return  new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
