package com.takisite.backend.util;

import java.util.Base64;

public class ImageUtils {


    public static byte[] decodeImage(String base64Image) {
        return Base64.getDecoder().decode(base64Image);
    }


    public static String encodeImage(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
