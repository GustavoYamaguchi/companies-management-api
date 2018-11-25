package com.companiesmanagementapi.companiesmanagementapi.repository;

import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByJobTitleContainingIgnoreCase(String word);

    public List<Employee> findByEmployer(Long id);
}
