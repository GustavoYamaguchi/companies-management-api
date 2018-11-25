package com.companiesmanagementapi.companiesmanagementapi.event.listener;

import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.model.Gender;
import com.companiesmanagementapi.companiesmanagementapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Autowired
    EmployeeRepository employeeRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedEmployeeTable();
    }

    private void seedEmployeeTable() {
        Employee employee = new Employee();
        employee.setId(new Long(1));
        employee.setName("Gustavo");
        employee.setGender(Gender.MALE);
        employee.setEmail("gustavo@email.com");
        employee.setCpf("11111111111");
        employee.setJobTitle("Software Developer");
        employeeRepository.save(employee);
    }
}
