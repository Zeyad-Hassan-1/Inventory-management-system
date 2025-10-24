/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.role;

import com.company.inventory_management_system.EmployeeUser;
import com.company.inventory_management_system.database.EmployeeUserDatabase;

/**
 *
 * @author Hazem
 *
 * On each and every method of this class (except setters & getters) the
 * following sequence is taken: 1- the database file (Employees.txt) is to be
 * read 2- database instance is updated 3- modification is done on the instance
 * 4- all modifications are saved before function returns
 */
public class AdminRole implements Role {

    private EmployeeUserDatabase database;

    public EmployeeUserDatabase getDatabase() {
        return database;
    }

    public void setDatabase(EmployeeUserDatabase database) {
        this.database = database;
    }

    public AdminRole() {
        database = new EmployeeUserDatabase("Employees.txt");
    }

    public void addEmployee(String employeeId, String name, String email,
            String address, String phoneNumber) {
        // following replace block could be later validated in main program but it should be written to ensure no data corruption
        employeeId = employeeId.replace(",", "");
        name = name.replace(",", "");
        email = email.replace(",", "");
        address = address.replace(",", "");
        phoneNumber = phoneNumber.replace(",", "");

        EmployeeUser employee = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.readFromFile();
        database.insertRecord(employee);
        database.saveToFile();
    }

    public EmployeeUser[] getListOfEmployees() {
        database.readFromFile();
        return database.returnAllRecords().toArray(new EmployeeUser[0]);
    }

    public boolean removeEmployee(String key) {
        database.readFromFile();
        if (database.deleteRecord(key)) {
            database.saveToFile();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void logout() {
        System.out.println("Logging out...");
        database.saveToFile();
    }
}
