package com.companiesmanagementapi.companiesmanagementapi.repository;

import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Industry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    public List<Company> findByNameContainingIgnoreCase(String word);

    public List<Company> findByIndustry(Industry industry);
}
