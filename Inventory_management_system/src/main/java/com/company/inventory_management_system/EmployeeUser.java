/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system;

import com.company.inventory_management_system.database.Record;

/**
 *
 * @author zeyad
 */
public class EmployeeUser implements Record {

    private String employeeId, Name, Email, Address, PhoneNumber;

    public EmployeeUser(String employeeId, String Name, String Email, String Address, String PhoneNumber) {
        this.employeeId = employeeId;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
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
