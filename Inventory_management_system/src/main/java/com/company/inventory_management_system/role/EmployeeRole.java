/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.role;

import com.company.inventory_management_system.Product;
import com.company.inventory_management_system.CustomerProduct;
import com.company.inventory_management_system.database.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Hazem
 */
public class EmployeeRole implements Role {

    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public ProductDatabase getProductsDatabase() {
        return productsDatabase;
    }

    public void setProductsDatabase(ProductDatabase productsDatabase) {
        this.productsDatabase = productsDatabase;
    }

    public CustomerProductDatabase getCustomerProductDatabase() {
        return customerProductDatabase;
    }

    public void setCustomerProductDatabase(CustomerProductDatabase customerProductDatabase) {
        this.customerProductDatabase = customerProductDatabase;
    }

    public EmployeeRole() {
        productsDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    }

    public void addProduct(String productID, String productName, String manufacturerName,
            String supplierName, int quantity, float price) {
        // following replace block could be later validated in main program but it should be written to ensure no data corruption
        productID = productID.replace(",", "");
        productName = productName.replace(",", "");
        manufacturerName = manufacturerName.replace(",", "");
        supplierName = supplierName.replace(",", "");

        Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productsDatabase.readFromFile();
        productsDatabase.insertRecord(product);
        productsDatabase.saveToFile();

    }

    public Product[] getListOfProducts() {
        productsDatabase.readFromFile();
        return productsDatabase.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        customerProductDatabase.readFromFile();
        return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();

        if (!productsDatabase.contains(productID)) {
            System.out.println("Product doesn't exist");
            return false;
        }

        Product target = (Product) productsDatabase.getRecord(productID);

        if (target.getQuantity() == 0) {
            System.out.println("Target out of stock");
            return false;
        }

        target.setQuantity(target.getQuantity() - 1);
        CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProductDatabase.insertRecord(customerProduct);

        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();

        return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();

        if (returnDate.isBefore(purchaseDate)) {
            System.out.println("Return date is earlier than purchase data");
            return -1;
        }

        if (!productsDatabase.contains(productID)) {
            System.out.println("Product doesn't exist");
            return -1;
        }

        if (ChronoUnit.DAYS.between(purchaseDate, returnDate) > 14) // calculates 2nd argument - 1st argument
        {
            System.out.println("More than 14 days since Return date & Purchase date");
            return -1;
        }

        CustomerProduct dummyPurchase = new CustomerProduct(customerSSN, productID, purchaseDate);
        if (!customerProductDatabase.contains(dummyPurchase.getSearchKey())) {
            System.out.println("Purchase not found");
            return -1;
        }

        Product targetProduct = (Product) productsDatabase.getRecord(productID);

        targetProduct.setQuantity(targetProduct.getQuantity() + 1);
        customerProductDatabase.deleteRecord(dummyPurchase.getSearchKey());

        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();

        return targetProduct.getPrice();

    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();

        boolean purchaseExists = false;

        //full class name for Record was used to get rid of the matching with java.lang.Record
        for (com.company.inventory_management_system.database.Record record : customerProductDatabase.returnAllRecords()) {
            CustomerProduct purchase = (CustomerProduct) record;
            if (purchase.getCustomerSSN().equals(customerSSN)
                    && purchase.getPurchaseDate().isEqual(purchaseDate)
                    && purchase.isPaid() == false) {
                purchaseExists = true;
                purchase.setPaid(true);
            }
        }
        return purchaseExists;
    }

    @Override
    public void logout() {

        System.out.println("Logging out...");
        customerProductDatabase.saveToFile();
        productsDatabase.saveToFile();

    }

}
