package com.companiesmanagementapi.companiesmanagementapi.repository;

import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
