/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.company.inventory_management_system;

import com.company.inventory_management_system.database.CustomerProductDatabase;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author zeyad
 */
public class Inventory_management_system {
    
        public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

//    public static boolean isValidDate(String dateStr) {
//        String[] parts = dateStr.split("-");
//        if (parts.length != 3) return false;
//        for (String part : parts) {
//            if (!isNumber(part)) return false;
//        }
//        int day = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int year = Integer.parseInt(parts[2]);
//        if (month < 1 || month > 12) return false;
//        if (day < 1 || day > 31) return false;
//        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) return false;
//        if (month == 2 && day > 29) return false;
//        return true;
//    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter customer SSN: ");
//        String ssn = scanner.nextLine();
//        
//        System.out.print("Enter Product ID: ");
//        String productID = scanner.nextLine();
//        
        System.out.println("input details of custome product");
        String Line = scanner.nextLine();
//        String dateInput = "";
//        while (true) {
//            System.out.print("Enter purchase date (DD-MM-YYYY): ");
//            dateInput = scanner.nextLine();
//            if (isValidDate(dateInput)) break;
//            System.out.println("Invalid date! Please try again.");
//        }
//        String[] parts = dateInput.split("-");
//        int day = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int year = Integer.parseInt(parts[2]);
//        LocalDate purchaseDate = LocalDate.of(year, month, day);
//        
//        System.out.print("Has the purchase been paid? (true/false): ");
//        boolean paid = scanner.nextBoolean();
//        
//        CustomerProduct purchase = new CustomerProduct(ssn, productID, purchaseDate);
//        purchase.setPaid(paid);
//        FileWriter writer = new FileWriter("CustomersProducts.txt", true);
//        writer.write(purchase.lineRepresentation() + "\n");
//        writer.close();
//        System.out.println("Purchase saved successfully!");
        CustomerProductDatabase customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
        CustomerProduct customerProduct = (CustomerProduct) customerProductDatabase.createRecordFrom(Line);
        customerProductDatabase.readFromFile();
        customerProductDatabase.insertRecord(customerProduct);
        customerProductDatabase.saveToFile();
        customerProductDatabase.readFromFile();

        scanner.close();
    }
}
