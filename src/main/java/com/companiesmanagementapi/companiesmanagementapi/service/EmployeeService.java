package com.companiesmanagementapi.companiesmanagementapi.service;

import com.companiesmanagementapi.companiesmanagementapi.exception.CouldNotRetrieveSeedInformationException;
import com.companiesmanagementapi.companiesmanagementapi.exception.InvalidDataRequestException;
import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.model.Gender;
import com.companiesmanagementapi.companiesmanagementapi.repository.EmployeeRepository;
import com.companiesmanagementapi.companiesmanagementapi.util.HttpClientUtil;
import com.companiesmanagementapi.companiesmanagementapi.util.template.response.RandomUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public static final String DEFAULT_RANDOM_USER_URL = "https://randomuser.me/api/?seed={}&results={}";

    public Employee save(Employee employee) throws InvalidDataRequestException, CouldNotRetrieveSeedInformationException {
        if (employee.getId() != null || employee.getName() != null ||
                employee.getGender() != null || employee.getEmail() != null) {
            throw new InvalidDataRequestException();
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
