package com.companiesmanagementapi.companiesmanagementapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    MALE("male"), FEMALE("female"), OTHER("other");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @JsonValue
    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return this.gender;
    }

    @JsonCreator
    public static Gender fromText(String gender) {
        for (Gender g: Gender.values()) {
            if (g.getGender().equals(gender)) {
                return g;
            }
        }
        throw new IllegalArgumentException();
    }
}
