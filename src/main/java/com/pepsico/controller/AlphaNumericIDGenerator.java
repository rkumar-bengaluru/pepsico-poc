package com.pepsico.controller;

import java.security.SecureRandom;

public class AlphaNumericIDGenerator {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {
        String generatedID = generateAlphaNumericID(10);
        System.out.println("Generated ID: " + generatedID);
    }

    public static String generateAlphaNumericID(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHA_NUMERIC_STRING.length());
            char randomChar = ALPHA_NUMERIC_STRING.charAt(randomIndex);
            builder.append(randomChar);
        }
        return builder.toString();
    }
}
