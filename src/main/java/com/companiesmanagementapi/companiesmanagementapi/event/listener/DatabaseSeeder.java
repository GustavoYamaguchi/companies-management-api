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

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        populateIndustryTable();
    }

    private void populateIndustryTable() {

    }
}
