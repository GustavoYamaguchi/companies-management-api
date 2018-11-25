package com.companiesmanagementapi.companiesmanagementapi.resource;

import com.companiesmanagementapi.companiesmanagementapi.constants.Url;
import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<Company> findAll(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public List<Company> findById(@PathVariable Long id){
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<Company> findByName(@RequestParam(Url.Param.COMPANY_NAME) String companyName){
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<Company> findByIndustry(@RequestParam(Url.Param.INDUSTRY) String industry){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}/" + Url.Path.EMPLOYEES)
    public List<Employee> findAllEmployeesByCompanyId(@PathVariable Long id) {
        throw new UnsupportedOperationException();
    }
}
