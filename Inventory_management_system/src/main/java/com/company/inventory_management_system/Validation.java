/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.inventory_management_system;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author afifi.store
 */
public class Validation {

    public static boolean notEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isAlphabetic(String value) {
        if (!Pattern.matches("^[A-Za-z ]+$", value)) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String value) {
        if (!Pattern.matches("^[0-9]+$", value)) {
            return false;
        }
        return true;
    }

    public static boolean validEmail(String email) {
        String pattern = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
        if (!Pattern.matches(pattern, email)) {
            System.err.println("Error: Invalid email format.");
            return false;
        }
        return true;
    }

    public static boolean isPositiveInt(int value) {
        return value >= 0;
    }
    public static boolean isPositiveFloat(float value) {
        return value >= 0.0;
    }

    public static boolean validPhone(String phone) {
        // Egyptian phone format ONLY /////////////////////////////
        String pattern = "^(\\+?2)?01[0-25][0-9]{8}$";
        if (!Pattern.matches(pattern, phone)) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    public static boolean isValidDate(String dateStr) 
    {
        String[] parts = dateStr.split("-");
        if (parts.length != 3)
            return false;
        for (String part : parts) {
            if (!isNumber(part))
                return false;
        }
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (month < 1 || month > 12)
            return false;
        if (day < 1 || day > 31)
            return false;
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
            return false;
        if (month == 2 && day > 29)
            return false;
        return true;
    }

}
