package com.java.organizationservice;

import com.java.organizationservice.dto.OrganizationDto;
import com.java.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDto mapToOrganizationDto(Organization organization){
        OrganizationDto organizationDto=new OrganizationDto(organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getOrganizationCreatedDateTime());
        return organizationDto;
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization=new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getOrganizationCreatedDateTime()
        );
        return  organization;
    }
}
