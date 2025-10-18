/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system;

import com.company.inventory_management_system.database.Record;

/**
 *
 * @author zeyad
 * @author hazem
 */
public class EmployeeUser implements Record {

    private String employeeId, name, email, address, phoneNumber;

    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber)  {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        return this.employeeId.concat(","+this.name+","+this.email+","+this.address+","+this.phoneNumber);
    }

    @Override
    public String getSearchKey() {
        return this.employeeId;
    }

}
