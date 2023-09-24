package com.java.organizationservice.service.impl;

import com.java.organizationservice.OrganizationMapper;
import com.java.organizationservice.dto.OrganizationDto;
import com.java.organizationservice.entity.Organization;
import com.java.organizationservice.repository.OrganizationRepository;
import com.java.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization= OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization= organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDto organizationDto= OrganizationMapper.mapToOrganizationDto(organization);
        return organizationDto;
    }

}
