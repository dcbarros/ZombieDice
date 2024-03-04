package com.zombiedice.utils;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class IdUtils {

    public static Long idGenerate(Integer idLength){
        Long seed = LocalDateTime.now().getLong(ChronoField.NANO_OF_DAY);
        SecureRandom random = new SecureRandom();
        random.setSeed(seed);
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < idLength - 1; i++) {
            id.append(random.nextInt(10));
        }

        Integer checkDigit = calculateCheckDigit(id.toString());
        id.append(checkDigit);
        return Long.parseLong(id.toString());
    }

    private static Integer calculateCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            sum += digit;
        }
        int checkDigit = sum % 10;
        return checkDigit == 0 ? 0 : 10 - checkDigit;
    }

    public static Boolean idIsValid(Long id){
        String idStr = String.valueOf(id);
        if(idStr.length() != 7) return false;
        String digits = idStr.substring(0, 6);
        int checkDigit = Character.getNumericValue(idStr.charAt(6));

        int calculatedCheckDigit = calculateCheckDigit(digits);

        return checkDigit == calculatedCheckDigit;
    }
}
