package com.lb.employeeleave.repository;

import com.lb.employeeleave.constant.enums.Status;
import com.lb.employeeleave.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    Page<Employee> findAll(Pageable pageable);

    Employee findByUsername(String username);

    Employee findByUsernameAndStatus(String username, Status status);

    // All employee under supervision of given employee
    List<Employee> findAllBySupervisor(Employee employee);

    Page<Employee> findByFirstNameStartingWithIgnoreCase(Pageable pageable, String fullName);
}
