/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.database;

import com.company.inventory_management_system.Product;
import com.company.inventory_management_system.Validation;

/**
 *
 * @author zeyad
 */
public class ProductDatabase extends Database {

    public ProductDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Record createRecordFrom(String line) {
        if (line == null) {
            System.out.println("please input the data separated by ,");
            return null;
        }
        String[] fields = line.replace(" ", "").split(",");
        if (fields.length != 6) {
            System.out.println("Invalid line input");
            return null;
        }
        int quantity = Integer.parseInt(fields[4]);
        if (!Validation.isPositiveInt(quantity)){
            quantity = 0;
        }
        float price = Float.parseFloat(fields[5]);
        if (!Validation.isPositiveFloat(price)){
            price = 0.0f;
        }

        return new Product(fields[0], fields[1], fields[2], fields[3], quantity, price);
    }

}
