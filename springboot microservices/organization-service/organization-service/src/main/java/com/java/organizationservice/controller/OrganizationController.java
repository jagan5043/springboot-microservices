package com.java.organizationservice.controller;

import com.java.organizationservice.dto.OrganizationDto;
import com.java.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Organization Service - Organization Controller",
        description = "Organization Controller exposes rest apis for Organization Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping()
    @Operation(
            summary = "SAVE Organization rest API",
            description = "SAVE Organization rest API is used to save Organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Organization Saved"
    )
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganizationDto=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }


    @GetMapping("/{organizationCode}")
    @Operation(
            summary = "GET Organization rest API",
            description = "GET Organization rest API is used to Fetch Organization object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Fetch successfully"
    )
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("organizationCode") String organizationCode){
        OrganizationDto organizationDto= organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDto,HttpStatus.OK);
    }
}
