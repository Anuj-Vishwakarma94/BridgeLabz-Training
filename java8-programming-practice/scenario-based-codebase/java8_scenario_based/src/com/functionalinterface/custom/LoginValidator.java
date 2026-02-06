package com.functionalinterface.custom;

@FunctionalInterface
public interface LoginValidator {
    boolean validate(String username, String password);
}

