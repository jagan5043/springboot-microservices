package com.java.organizationservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {
       @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String organizationName;
        private String organizationDescription;
        @Column(nullable = false,unique = true)
        private String organizationCode;
        @CreationTimestamp
        private LocalDateTime organizationCreatedDateTime;

}
