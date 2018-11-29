package com.companiesmanagementapi.companiesmanagementapi.service;

import com.companiesmanagementapi.companiesmanagementapi.constants.Message;
import com.companiesmanagementapi.companiesmanagementapi.exception.ResourceNotFoundException;
import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Industry;
import com.companiesmanagementapi.companiesmanagementapi.repository.CompanyRepository;
import com.companiesmanagementapi.companiesmanagementapi.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IndustryRepository industryRepository;

    public Company save(Company company) throws ResourceNotFoundException {
        Long industryId = company.getIndustry().getId();
        Industry industry = industryRepository.findOne(industryId);
        if (industry == null) {
            throw new ResourceNotFoundException(String.format(Message.Exception.RESOURCE_NOT_FOUND,
                    Message.ResourceName.INDUSTRY, industryId));
        }
        return companyRepository.save(company);
    }
}
