package com.companiesmanagementapi.companiesmanagementapi.resource;

import com.companiesmanagementapi.companiesmanagementapi.constants.Url;
import com.companiesmanagementapi.companiesmanagementapi.exception.ResourceNotFoundException;
import com.companiesmanagementapi.companiesmanagementapi.model.Company;
import com.companiesmanagementapi.companiesmanagementapi.model.Employee;
import com.companiesmanagementapi.companiesmanagementapi.model.Industry;
import com.companiesmanagementapi.companiesmanagementapi.repository.CompanyRepository;
import com.companiesmanagementapi.companiesmanagementapi.repository.EmployeeRepository;
import com.companiesmanagementapi.companiesmanagementapi.repository.IndustryRepository;
import com.companiesmanagementapi.companiesmanagementapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/" + Url.Path.COMPANIES_ENDPOINT)
public class CompanyResource {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private IndustryRepository industryRepository;

    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) throws ResourceNotFoundException {
        Company newCompany = companyService.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
    }

    @GetMapping
    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable Long id){
        return companyRepository.findOne(id);
    }

    @GetMapping(params = Url.Param.COMPANY_NAME)
    public List<Company> findByCompanyName(@RequestParam(Url.Param.COMPANY_NAME) String word){
        return companyRepository.findByNameContainingIgnoreCase(word);
    }

    @GetMapping(params = Url.Param.INDUSTRY)
    public List<Company> findByIndustry(@RequestParam(Url.Param.INDUSTRY) Long industryId){
        Industry industry = industryRepository.findOne(industryId);
        return companyRepository.findByIndustry(industry);
    }

    @GetMapping("/{id}/" + Url.Path.EMPLOYEES)
    public List<Employee> findAllEmployeesByCompanyId(@PathVariable Long id) {
        Company company = companyRepository.findOne(id);
        return employeeRepository.findByEmployer(company);
    }
}
