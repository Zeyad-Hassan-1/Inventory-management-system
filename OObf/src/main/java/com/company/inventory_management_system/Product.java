package com.company.inventory_management_system;

import com.company.inventory_management_system.Validation;
import com.company.inventory_management_system.database.Record;


public class Product  implements Record{

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

        this.quantity = Validation.isPositive(quantity) ? quantity : 0;

        this.price = Validation.isPositive((int) price) ? price : 0.0f;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Validation.isPositive(quantity) ? quantity : this.quantity;
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
        this.price = Validation.isPositive((int) price) ? price : this.price;
    }

    @Override
    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + ","
                + supplierName + "," + quantity + "," + price;
    }

    @Override
    public String getSearchKey() {
        return productID;
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

    public float totalValueInStock() {
        System.out.println("totalValueInStock: " + price * quantity);
        float y = price * quantity;
        return y;
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

}
