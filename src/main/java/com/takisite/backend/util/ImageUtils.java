package com.takisite.backend.util;

import java.util.Base64;

public class ImageUtils {

    /**
     * Base64 string olarak gelen resmi decode eder (binary).
     */
    public static byte[] decodeImage(String base64Image) {
        return Base64.getDecoder().decode(base64Image);
    }

    /**
     * Binary resmi base64 string formatına çevirir.
     */
    public static String encodeImage(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
