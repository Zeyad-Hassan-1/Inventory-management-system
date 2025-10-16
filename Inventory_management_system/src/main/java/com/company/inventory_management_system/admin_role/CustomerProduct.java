/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.admin_role;

import com.company.inventory_management_system.database.Record;
import java.time.LocalDate;

/**
 *
 * @author zeyad
 */
public class CustomerProduct implements Record {
    private String customerSSN, productID;
    private LocalDate purchaseDate;
    private boolean paid;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
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
