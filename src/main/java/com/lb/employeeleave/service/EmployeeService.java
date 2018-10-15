package com.lb.employeeleave.service;

import com.lb.employeeleave.dto.EmployeeDTO;
import com.lb.employeeleave.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface EmployeeService {

    @PreAuthorize ("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    Page<EmployeeDTO> getAllEmployees(Pageable pageable);

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    EmployeeDTO retrieveAuthenticatedEmployee();

    @PreAuthorize ("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    EmployeeDTO getEmployeeById(Long id);

    // only allowed to admin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    // only allowed to admin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    // only allowed to admin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<EmployeeDTO> getAllEmployeeUnderSupervision(Long id);

    @PreAuthorize ("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    Page<EmployeeDTO> getAllEmployeesByName(Pageable pageable, String fullName);
}
