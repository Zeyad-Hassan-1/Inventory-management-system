/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.inventory_management_system;

/**
 *
 * @author afifi.store
 */


public class Validation {

    public static boolean notEmpty(String value) {
        return !(value == null || value.trim().isEmpty());
    }

    /**
     * 
     * @param s
     * @return 1 in case of 'y' or 'Y',
     *         0 in case of 'n' or 'N',
     *         -1 otherwise.
     */
    public static int isConfirmationResponse(String s)
    {
        if(s.length()!=1)
        {
            return -1;
        }
        s=s.toUpperCase();
        char temp = s.charAt(0);
        if(temp == 'Y')
        {
            return 1;
        }
        if(temp == 'N')
        {
            return 0;
        }
        return -1;
        
    }
    
    public static boolean isAlphabetic(String value, String fieldName) {
        if (value == null) {
            System.err.println("Error: " + fieldName + " cannot be null.");
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
                System.err.println("Error: " + fieldName + " must contain only letters.");
                return false;
            }
        }
        return true;
    }

        // ---------------------------------------------------------
    public static boolean isNumeric(String value, String fieldName) {
        if (value == null) {
            System.err.println("Error: " + fieldName + " cannot be null.");
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                System.err.println("Error: " + fieldName + " must contain only digits.");
                return false;
            }
        }
        return true;
    }
        // ---------------------------------------------------------

    
   public static boolean validEmail(String email) {
        if (email == null) {
            System.err.println("Error: Email cannot be null.");
            return false;
        }

        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            System.err.println("Error: Email must contain '@'.");
            return false;
        }

        int dotIndex = email.indexOf('.', atIndex);
        if (dotIndex == -1) {
            System.err.println("Error: Email must contain '.' after '@'.");
            return false;
        }

        if (email.startsWith("@") || email.endsWith("@") || email.startsWith(".") || email.endsWith(".")) {
            System.err.println("Error: Email cannot start or end with '@' or '.'.");
            return false;
        }

 
        String namePart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1, dotIndex);
        String extensionPart = email.substring(dotIndex + 1);

        if (namePart.isEmpty() || domainPart.isEmpty() || extensionPart.length() < 2) {
            System.err.println("Error: Invalid email structure.");
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

    public static boolean isPositiveInt(String str) {
        if(isInt(str))
        {
            return Integer.parseInt(str)>=0;
        }
        return false;
    }
    
    public static boolean isPositiveFloat(String str) {
        if(isFloat(str))
        {
            return Double.parseDouble(str)>=0.0;
        }
        return false;
    }

    public static boolean validPhone(String phone) {
        if (phone == null) {
            System.err.println("Error: Phone cannot be null.");
            return false;
        }

        if (phone.startsWith("+201")) {
            if (phone.length() != 13) {
                System.err.println("Error: Invalid phone number length.");
                return false;
            }
        } else if (phone.startsWith("01")) {
            if (phone.length() != 11) {
                System.err.println("Error: Invalid phone number length.");
                return false;
            }
        } else {
            System.err.println("Error: Phone number must start with '01' or '+201'.");
            return false;
        }


        for (int i = (phone.startsWith("+") ? 1 : 0); i < phone.length(); i++) {
            char c = phone.charAt(i);
            if (c < '0' || c > '9') {
                System.err.println("Error: Phone number must contain only digits.");
                return false;
            }
        }

        return true;
    }

    public static boolean isInt(String str) {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    public static boolean isFloat(String str) {
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean isValidDate(String dateStr) 
    {
        String[] parts = dateStr.split("-");
        if (parts.length != 3)
            return false;
        for (String part : parts) {
            if (!isPositiveInt(part))
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

    public static boolean validName(String name) {
    if (name == null) return false;

    name = name.trim();
    if (name.isEmpty()) return false;

    if (!name.matches("^[A-Za-z ]+$")) return false;

    return !name.contains("  ");
}

}
