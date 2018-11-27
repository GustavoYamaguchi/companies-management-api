package com.companiesmanagementapi.companiesmanagementapi.util;

import org.springframework.web.client.RestTemplate;

public class HttpClientUtil {

    public static String get(String url, String... variables) {
        String result = new RestTemplate().getForObject(url, String.class, variables);
        return result;
    }
}
