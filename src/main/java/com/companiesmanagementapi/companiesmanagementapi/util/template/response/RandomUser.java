package com.companiesmanagementapi.companiesmanagementapi.util.template.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUser {

    @SerializedName("results")
    private List<Result> results;

    public static RandomUser fromJson(String json) {
        return new Gson().fromJson(json, RandomUser.class);
    }

    public class Result {

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
    }
}
