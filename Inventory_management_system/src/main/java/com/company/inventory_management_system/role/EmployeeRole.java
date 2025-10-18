/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.role;

import com.company.inventory_management_system.Product;
import com.company.inventory_management_system.CustomerProduct;
import com.company.inventory_management_system.database.CustomerProductDatabase;
import com.company.inventory_management_system.database.Database;
import com.company.inventory_management_system.database.ProductDatabase;
import java.time.LocalDate;

/**
 *
 * @author Hazem
 */
public class EmployeeRole extends Role {
    private ProductDatabase productsDatabase = null;
    private CustomerProductDatabase customerProductDatabase = null;

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
    }
    
    public void addProduct(String productID, String productName, String manufacturerName,
                           String supplierName, int quantity, float price)
    {
       if(productsDatabase == null)
        {
            noDatabaseAssignedError(productsDatabase);
            return;
        } 
       
       Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
       productsDatabase.readFromFile();
       productsDatabase.insertRecord(product);
       productsDatabase.saveToFile();
       
    }
    
    public Product[] getListOfProducts()
    {
        if(productsDatabase == null)
        {
            noDatabaseAssignedError(productsDatabase);
            return null;
        } 
        productsDatabase.readFromFile();
        return productsDatabase.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations()
    {
        if(customerProductDatabase == null)
        {
            noDatabaseAssignedError(customerProductDatabase);
            return null;
        } 
        customerProductDatabase.readFromFile();
        return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
    }
    
    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        if(productsDatabase == null)
        {
            noDatabaseAssignedError(productsDatabase);
            return false;
        }
        
        if(customerProductDatabase == null)
        {
            noDatabaseAssignedError(customerProductDatabase);
            return false;
        }
        
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();
        
        if(!productsDatabase.contains(productID))
        {
            System.out.println("Product doesn't exist");
            return false;
        }
        
        Product target = (Product) productsDatabase.getRecord(productID);
        
        if(target.getQuantity==0)
        {
            System.out.println("Target out of stock");
            return false;
        }
        
        target.setQuantity(target.getQuantity()-1);
//        CustomerProduct customerProduct = new CustomerProduct(customerSSN,productID,purchaseDate);
        customerProductDatabase.insertRecord(customerProduct);
        
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
        
        return true;
    }
    
//    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate ,LocalDate returnDate)
//    {
//        
//    }
    
    @Override
    public void logout() {
        
        if(customerProductDatabase != null)
        {
            customerProductDatabase.saveToFile();
            
        }
        else
        {
           noDatabaseAssignedError(customerProductDatabase); 
        }
        
        if(productsDatabase != null)
        {
           productsDatabase.saveToFile();
        }
        else
        {
            noDatabaseAssignedError(productsDatabase);
        }
    }
    
}
