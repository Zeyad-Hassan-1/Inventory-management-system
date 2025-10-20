/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.database;

import com.company.inventory_management_system.CustomerProduct;
import com.company.inventory_management_system.Validation;

import java.time.LocalDate;

/**
 *
 * @author zeyad
 */
public class CustomerProductDatabase extends Database{

    public CustomerProductDatabase(String fileName) {
        super(fileName);
    }
    
    

    @Override
    public Record createRecordFrom(String line) {
        if(line == null){
            System.out.println("please input the data separated by ,");
            return null;
        }
        String[] fields = line.replace(" ","").split(",");
        if(fields.length != 4){
            System.out.println("Invalid line input");
            return  null;
        }
        // the default formatter is yyyy-mm-dd so need to make the our formatter.
        if (!Validation.isValidDate(fields[2])) return null;
        CustomerProduct purchase =  new CustomerProduct(fields[0],fields[1],LocalDate.parse(fields[2], CustomerProduct.getFORMATTER()));
        if(fields[3].equals("true"))
            purchase.setPaid(true);
        return purchase;
    }
    
}
