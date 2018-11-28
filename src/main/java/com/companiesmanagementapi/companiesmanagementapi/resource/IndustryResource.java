package com.companiesmanagementapi.companiesmanagementapi.resource;

import com.companiesmanagementapi.companiesmanagementapi.constants.Url;
import com.companiesmanagementapi.companiesmanagementapi.model.Industry;
import com.companiesmanagementapi.companiesmanagementapi.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/" + Url.Path.INDUSTRIES_ENDPOINT)
public class IndustryResource {

    @Autowired
    IndustryRepository industryRepository;

    @GetMapping
    public List<Industry> findAllIndustries() {
        return industryRepository.findAll();
    }
}
