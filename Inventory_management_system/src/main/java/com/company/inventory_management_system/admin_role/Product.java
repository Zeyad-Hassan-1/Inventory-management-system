/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.admin_role;

import com.company.inventory_management_system.database.Record;

/**
 *
 * @author zeyad
 */
public class Product implements Record {

    private String productID, productName, manufacturerName, supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }
    

    @Override
    public String lineRepresentation() {
        return null;
    }

    @Override
    public String getSearchKey() {
        return null;
    }

}
