package com.companiesmanagementapi.companiesmanagementapi.resource;

import com.companiesmanagementapi.companiesmanagementapi.constants.Url;
import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/" + Url.Path.EMPLOYEES_ENPOINT)
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        throw new UnsupportedOperationException();
    }

    @GetMapping(params = Url.Param.JOB_TITLE)
    public List<Employee> findByJobTitle(@RequestParam(Url.Param.JOB_TITLE) String jobTitle) {
        throw new UnsupportedOperationException();
    }
}
