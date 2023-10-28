package com.java.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Organization Model Information"
)
public class OrganizationDto {
    private Long id;
    @Schema(
            description = "organization name"
    )
    private String organizationName;
    @Schema(
            description = "organization description"
    )
    private String organizationDescription;
    @Schema(
            description = "organization code"
    )
    private String organizationCode;
    @Schema(
            description = "organization createdDateTime"
    )
    private LocalDateTime organizationCreatedDateTime;
}
