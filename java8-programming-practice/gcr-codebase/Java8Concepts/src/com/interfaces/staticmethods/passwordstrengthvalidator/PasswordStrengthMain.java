package com.interfaces.staticmethods.passwordstrengthvalidator;

public class PasswordStrengthMain {

    private static void testPassword(String password) {

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Strong Password");
        } else {
            System.out.println("Weak Password");
        }
    }

    public static void main(String[] args) {
        testPassword("vaidik1234");
        testPassword("pass");
    }
}

