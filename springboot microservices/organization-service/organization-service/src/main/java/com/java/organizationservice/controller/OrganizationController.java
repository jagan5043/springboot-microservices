package com.java.organizationservice.controller;

import com.java.organizationservice.dto.OrganizationDto;
import com.java.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping()
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganizationDto=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }


    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("organizationCode") String organizationCode){
        OrganizationDto organizationDto= organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDto,HttpStatus.OK);
    }
}
