package com.companiesmanagementapi.companiesmanagementapi.event.listener;

import com.companiesmanagementapi.companiesmanagementapi.model.Industry;
import com.companiesmanagementapi.companiesmanagementapi.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Autowired
    IndustryRepository industryRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        populateIndustryTable();
    }

    private void populateIndustryTable() {
        String[] industries = {"Tobacco", "Airlines", "Lawyers & Lobbyists", "Electronics, Defense Contractors",
                "Health Services/HMOs", "Computer Software", "Hotels, Motels & Tourism",
                "Energy & Natural Resources", "Postal Unions", "Foreign & Defense Policy",
                "Pharmaceutical Manufacturing", "Timber, Logging & Paper Mills", "TV Production",
                "Ideological/Single-Issue", "Meat processing & products" };

        for (String industryName: industries) {
            Industry industry = new Industry();
            industry.setName(industryName);
            industryRepository.save(industry);
        }
    }
}
