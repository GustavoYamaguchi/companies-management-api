package com.companiesmanagementapi.companiesmanagementapi.repository;

import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
