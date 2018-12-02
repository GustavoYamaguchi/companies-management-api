package com.companiesmanagementapi.companiesmanagementapi.service;

import com.companiesmanagementapi.companiesmanagementapi.TestUtils;
import com.companiesmanagementapi.companiesmanagementapi.exception.CouldNotRetrieveSeedInformationException;
import com.companiesmanagementapi.companiesmanagementapi.exception.InvalidDataRequestException;
import com.companiesmanagementapi.companiesmanagementapi.exception.ResourceNotFoundException;
import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.model.Gender;
import com.companiesmanagementapi.companiesmanagementapi.repository.CompanyRepository;
import com.companiesmanagementapi.companiesmanagementapi.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

    private Employee employee;

    @TestConfiguration
    static class EmployeeServiceTestConfiguration {
        @MockBean
        private EmployeeRepository employeeRepository;
        @MockBean
        private CompanyRepository companyRepository;

        @Bean
        public EmployeeService employeeServiceTest() {
            return new EmployeeService();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @Before
    public void setUp() {
        employee = TestUtils.createEmployee();
    }

    @Test
    public void createEmployeeWithId()
            throws ResourceNotFoundException, CouldNotRetrieveSeedInformationException {
        employee.setId(TestUtils.FAKE_EMPLOYEE_ID);
        try {
            employeeService.save(employee);
            Assert.fail();
        } catch (InvalidDataRequestException e) {
        }
    }

    @Test
    public void createEmployeeWithName()
            throws ResourceNotFoundException, CouldNotRetrieveSeedInformationException {
        employee.setName(TestUtils.FAKE_NAME);
        try {
            employeeService.save(employee);
            Assert.fail();
        } catch (InvalidDataRequestException e) {
        }
    }

    @Test
    public void createEmployeeWithGender()
            throws ResourceNotFoundException, CouldNotRetrieveSeedInformationException {
        employee.setGender(Gender.MALE);
        try {
            employeeService.save(employee);
            Assert.fail();
        } catch (InvalidDataRequestException e) {
        }
    }

    @Test
    public void createEmployeeWithEmail()
            throws ResourceNotFoundException, CouldNotRetrieveSeedInformationException {
        employee.setEmail(TestUtils.FAKE_EMAIL);
        try {
            employeeService.save(employee);
            Assert.fail();
        } catch (InvalidDataRequestException e) {
        }
    }

    @Test
    public void createEmployeeWithNonExistentCompany()
            throws CouldNotRetrieveSeedInformationException, InvalidDataRequestException {
        Company company = TestUtils.createCompany();
        company.setId(TestUtils.NON_USED_ID);
        employee.setEmployer(company);
        try {
            employeeService.save(employee);
            Assert.fail();
        } catch (ResourceNotFoundException e) {
        }
    }
}
