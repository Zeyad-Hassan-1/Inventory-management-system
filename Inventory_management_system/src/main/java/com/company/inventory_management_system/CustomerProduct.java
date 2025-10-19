/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.company.inventory_management_system.database.Record;

/**
 *
 * @author zeyad
 */
public class CustomerProduct implements Record{
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");// the default formatter is yyyy-mm-dd so need to make the our formatter.

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false;
    }

    public static DateTimeFormatter getFORMATTER() {
        return FORMATTER;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate(){
        return purchaseDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String lineRepresentation() {
        return customerSSN + "," + productID + "," + purchaseDate.format(FORMATTER) + "," + paid ;
    }

    @Override
    public String getSearchKey() {
        return customerSSN + "," + productID + "," + purchaseDate.format(FORMATTER);
    }  
}
