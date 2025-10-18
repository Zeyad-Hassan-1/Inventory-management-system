package com.company.inventory_management_system;

import com.company.inventory_management_system.database.Record;
import java.util.ArrayList;
import java.util.Scanner;

public class Product implements Record{

    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName,
            String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;

        if (quantity < 0) {
                        this.quantity = 0;

            System.out.println(" Quantity cannot be negative Default value (0) used");
        } else {
            this.quantity = quantity;
        }

        if (price <= 0) {
            this.price = 1;
            System.out.println(" Invalid price! Default value (1) used.");
        } else {
            this.price = price;
        }
    }
    
   

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
        } else {
            this.quantity = quantity;
            displayInfo();
        }
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price > 0) {
            this.price = price;
            displayInfo();

        } else {
            System.out.println("Price must be greater than 0.");
        }
    }

    @Override
    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + ","
                + supplierName + "," + quantity + "," + price;
    }

    public void displayInfo() {
        System.out.println("=== Product Details ===");
        System.out.println("ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Manufacturer: " + manufacturerName);
        System.out.println("Supplier: " + supplierName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("------------------------------");
    }

    @Override
    public String getSearchKey() {
        return productID;
    }

    public float totalValueInStock() {
        System.out.println("totalValueInStock: " + price * quantity  );
    float y = price * quantity ; 
    return y ; 
    }

    public boolean sellQuantity(int amount) {
        if (amount > 0 && quantity >= amount) {
            quantity -= amount;

            System.out.println("Sold " + amount + " units. Remaining: " + quantity);
            return true;
        } else {
            System.out.println(" Not enough stock to sell " + amount + " units.");
            return false;
        }
    }

    public void addQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Added " + amount + " units. New quantity: " + quantity);

        } else {
            System.out.println(" Invalid amount. Must be greater than zero.");
        }
    }

    public static boolean isProductIDUnique(String newID, ArrayList<Product> products) {
        if (newID == null || products == null) {
            return false;
        }
        for (Product p : products) {
            String key = p.getSearchKey();
            if (key != null && key.equalsIgnoreCase(newID)) {
                return false;
            }
        }
        return true;
    }
    


}
