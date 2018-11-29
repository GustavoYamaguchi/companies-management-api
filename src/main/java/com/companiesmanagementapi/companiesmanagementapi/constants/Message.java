package com.companiesmanagementapi.companiesmanagementapi.constants;

public class Message {

    public static class Exception {
        public static final String INVALID_DATA_REQUEST = "Invalid data in request. Please, check " +
                "our documentation.";
        public static final String COULD_NOT_RETRIEVE_SEED_INFORMATION = "Could not retrieve seed information." +
                " Please, check seed informed.";
        public static final String RESOURCE_NOT_FOUND = "Could not find %s with id %d";
    }

    public static class Error {
        public static final String INVALID_EMAIL = "Invalid email address.";
    }

    public static class ResourceName {
        public static final String INDUSTRY = "Industry";
        public static final String COMPANY = "Company";
        public static final String EMPLOYEE = "Employee";
    }
}
