package com.optionalclass.appconfig;

import java.util.Optional;

public class ApiResponse {

    private String value;

    public ApiResponse(String value) {
        this.value = value;
    }

    public Optional<String> getValue() {
        return Optional.ofNullable(value);
    }
}

