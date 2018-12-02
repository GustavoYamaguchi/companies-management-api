package com.companiesmanagementapi.companiesmanagementapi;

import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.model.Industry;

public class TestUtils {

    public static final String FAKE_NAME = "fake-name";
    public static final String FAKE_CPF = "fake-cpf";
    public static final String FAKE_CNPJ = "fake-cnpj";
    public static final String FAKE_PHONE_NUMBER = "4789-13548";
    public static final String FAKE_WEBSITE = "www.website.com";
    public static final String FAKE_EMAIL = "fake-email";
    public static final String FAKE_SEED = "fake-seed";
    public static final long FAKE_COMPANY_ID = 1;
    public static final long FAKE_INDUSTRY_ID = 2;
    public static final long FAKE_EMPLOYEE_ID = 3;
    public static final long NON_USED_ID = -1;

    public static Company createCompany() {
        Industry industry = createIndustry();
        Company company = new Company();
        company.setId(FAKE_COMPANY_ID);
        company.setName(FAKE_NAME);
        company.setCnpj(FAKE_CNPJ);
        company.setTelephone(FAKE_PHONE_NUMBER);
        company.setWebsite(FAKE_WEBSITE);
        company.setIndustry(industry);
        return company;
    }

    public static Employee createEmployee() {
        Company company = createCompany();
        Employee employee = new Employee();
        employee.setCpf(FAKE_CPF);
        employee.setEmployer(company);
        employee.setSeed(FAKE_SEED);
        return employee;
    }

    public static Industry createIndustry() {
        Industry industry = new Industry();
        industry.setId(new Long(FAKE_INDUSTRY_ID));
        industry.setName(FAKE_NAME);
        return industry;
    }
}
