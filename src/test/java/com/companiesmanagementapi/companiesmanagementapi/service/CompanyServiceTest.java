package com.companiesmanagementapi.companiesmanagementapi.service;

import com.companiesmanagementapi.companiesmanagementapi.TestUtils;
import com.companiesmanagementapi.companiesmanagementapi.exception.ResourceNotFoundException;
import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Industry;
import com.companiesmanagementapi.companiesmanagementapi.repository.CompanyRepository;
import com.companiesmanagementapi.companiesmanagementapi.repository.IndustryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
public class CompanyServiceTest {

    @TestConfiguration
    static class CompanyServiceTestConfiguration {
        @MockBean
        private CompanyRepository companyRepository;

        @Bean
        public CompanyService companyServiceTest() {
            return new CompanyService();
        }
    }

    @Autowired
    private CompanyService companyService;

    @MockBean
    private IndustryRepository industryRepository;

    private Company company;

    @Test
    public void createCompanyWithNonexistentIndustry() {
        company = TestUtils.createCompany();
        try {
            companyService.save(company);
            Assert.fail();
        } catch (ResourceNotFoundException e) {
        }
    }

    @Test
    public void createCompanyWhenIndustryExists() {
        Industry industry = TestUtils.createIndustry();
        Mockito.when(industryRepository.findOne(industry.getId()))
                .thenReturn(industry);

        company = TestUtils.createCompany();
        try {
            companyService.save(company);
        } catch (ResourceNotFoundException e) {
            Assert.fail();
        }
    }
}
