package com.java.departmentservice.repository;

import com.java.departmentservice.entity.Department;
import com.java.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Optional<Department> findByDepartmentCode(String departmentCode);


}
