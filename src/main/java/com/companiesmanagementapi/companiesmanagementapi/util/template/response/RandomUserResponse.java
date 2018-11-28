package com.companiesmanagementapi.companiesmanagementapi.util.template.response;

import com.companiesmanagementapi.companiesmanagementapi.constants.Response;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUserResponse {

    @SerializedName(Response.RESULTS_JSON_KEY)
    private List<RandomUser> randomUsers;

    public static RandomUserResponse fromJson(String json) {
        return new Gson().fromJson(json, RandomUserResponse.class);
    }

    public List<RandomUser> getRandomUsers() {
        return randomUsers;
    }

    public class RandomUser {

        private String gender;

        private String email;

        private Name name;

        public class Name {

            private String first;
            private String last;

            public String getFirst() {
                return first;
            }

            public String getLast() {
                return last;
            }
        }

        public String getGender() {
            return gender;
        }

        public String getEmail() {
            return email;
        }

        public Name getName() {
            return name;
        }
    }
}
