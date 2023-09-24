package com.java.organizationservice.repository;

import com.java.organizationservice.dto.OrganizationDto;
import com.java.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String organizationCode);
}
