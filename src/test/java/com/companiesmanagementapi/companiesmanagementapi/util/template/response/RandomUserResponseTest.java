package com.companiesmanagementapi.companiesmanagementapi.util.template.response;

import com.companiesmanagementapi.companiesmanagementapi.model.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomUserResponseTest {

    private String jsonResponse = "{\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"gender\": \"female\",\n" +
            "      \"name\": {\n" +
            "        \"title\": \"mrs\",\n" +
            "        \"first\": \"cassandre\",\n" +
            "        \"last\": \"dumas\"\n" +
            "      },\n" +
            "      \"email\": \"cassandre.dumas@example.com\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"gender\": \"female\",\n" +
            "      \"name\": {\n" +
            "        \"title\": \"madame\",\n" +
            "        \"first\": \"melanie\",\n" +
            "        \"last\": \"lacroix\"\n" +
            "      },\n" +
            "      \"email\": \"melanie.lacroix@example.com\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"info\": {\n" +
            "    \"seed\": \"a6bbfda0ab14c905\",\n" +
            "    \"results\": 2,\n" +
            "    \"page\": 1,\n" +
            "    \"version\": \"1.2\"\n" +
            "  }\n" +
            "}";

    @Test
    public void testMultiplePeopleResponse() {
        RandomUserResponse response = RandomUserResponse.fromJson(jsonResponse);
        Assert.assertEquals(2, response.getRandomUsers().size());

        RandomUserResponse.RandomUser person1 = response.getRandomUsers().get(0);
        RandomUserResponse.RandomUser person2 = response.getRandomUsers().get(1);

        Assert.assertEquals("cassandre.dumas@example.com", person1.getEmail());
        Assert.assertEquals("melanie.lacroix@example.com", person2.getEmail());

        Assert.assertEquals(Gender.FEMALE.toString(), person1.getGender());
        Assert.assertEquals(Gender.FEMALE.toString(), person2.getGender());

        Assert.assertEquals("cassandre", person1.getName().getFirst());
        Assert.assertEquals("melanie", person2.getName().getFirst());

        Assert.assertEquals("dumas", person1.getName().getLast());
        Assert.assertEquals("lacroix", person2.getName().getLast());
    }
}
