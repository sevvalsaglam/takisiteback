package com.takisite.backend.util;

import java.util.Random;

public class RandomUtils {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateRandomCode(int length) {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(rnd.nextInt(CHARACTERS.length())));
        }

        return sb.toString();
    }

    public static int generateRandomInt(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt((max - min) + 1) + min;
    }
}
