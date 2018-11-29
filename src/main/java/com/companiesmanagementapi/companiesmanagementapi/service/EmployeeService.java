package com.companiesmanagementapi.companiesmanagementapi.service;

import com.companiesmanagementapi.companiesmanagementapi.constants.Message;
import com.companiesmanagementapi.companiesmanagementapi.exception.CouldNotRetrieveSeedInformationException;
import com.companiesmanagementapi.companiesmanagementapi.exception.InvalidDataRequestException;
import com.companiesmanagementapi.companiesmanagementapi.exception.ResourceNotFoundException;
import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.model.Gender;
import com.companiesmanagementapi.companiesmanagementapi.repository.CompanyRepository;
import com.companiesmanagementapi.companiesmanagementapi.repository.EmployeeRepository;
import com.companiesmanagementapi.companiesmanagementapi.util.HttpClientUtil;
import com.companiesmanagementapi.companiesmanagementapi.util.template.response.RandomUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public static final String DEFAULT_RANDOM_USER_URL = "https://randomuser.me/api/?seed={}&results={}";

    public Employee save(Employee employee) throws InvalidDataRequestException, CouldNotRetrieveSeedInformationException,
            ResourceNotFoundException {
        if (employee.getId() != null || employee.getName() != null ||
                employee.getGender() != null || employee.getEmail() != null) {
            throw new InvalidDataRequestException();
        }
        Long companyId = employee.getEmployer().getId();
        Company company = companyRepository.findOne(companyId);
        if (company == null) {
            throw new ResourceNotFoundException(String.format(Message.Exception.RESOURCE_NOT_FOUND,
                    Message.ResourceName.COMPANY, companyId));
        }
        updateEmployeeDataBySeed(employee);
        return employeeRepository.save(employee);
    }

    private void updateEmployeeDataBySeed(Employee employee) throws CouldNotRetrieveSeedInformationException {
        String randomUserListStr = HttpClientUtil.get(DEFAULT_RANDOM_USER_URL, employee.getSeed(), "1");
        RandomUserResponse randomUserResponse = RandomUserResponse.fromJson(randomUserListStr);
        if (randomUserResponse.getRandomUsers().size() <= 0) {
            throw new CouldNotRetrieveSeedInformationException();
        }
        RandomUserResponse.RandomUser randomUser = randomUserResponse.getRandomUsers().get(0);
        employee.setGender(Gender.fromText(randomUser.getGender()));
        employee.setName(getName(randomUser));
        employee.setEmail(randomUser.getEmail());
    }

    private String getName(RandomUserResponse.RandomUser randomUser) {
        return randomUser.getName().getFirst() + " " + randomUser.getName().getLast();
    }
}
