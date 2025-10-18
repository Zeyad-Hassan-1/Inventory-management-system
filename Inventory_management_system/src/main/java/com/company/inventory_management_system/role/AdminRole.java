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
 * On each and every method of this class (except setters & getters) the following sequence is taken:
 * 1- the database file (Employees.txt) is to be read
 * 2- database instance is updated
 * 3- modification is done on the instance
 * 4- all modifications are saved before function returns
 */
public class AdminRole extends Role{
    
    private EmployeeUserDatabase database = null;
    
    public EmployeeUserDatabase getDatabase() {
        return database;
    }

    public void setDatabase(EmployeeUserDatabase database) {
        this.database = database;
    }
    
    public AdminRole(){}
    
    public void addEmployee(String employeeId, String name, String email,
                            String address, String phoneNumber)
    {
        if(database == null)
        {
            noDatabaseAssignedError(database);
            return;
        }
        
        EmployeeUser employee = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.readFromFile();
        database.insertRecord(employee);
        database.saveToFile();
    }

    public EmployeeUser[] getListOfEmployees()
    {
        if(database == null)
        {
            noDatabaseAssignedError(database);
            return null;
        }
        database.readFromFile();
        return database.returnAllRecords().toArray(new EmployeeUser[0]);
    }
    
    public void removeEmployee(String key)
    {
        if(database == null)
        {
            noDatabaseAssignedError(database);
            return;
        }
        database.readFromFile();
        database.deleteRecord(key);
        database.saveToFile();
    }
    
    @Override
    public void logout()
    {
        if(database == null)
        {
            noDatabaseAssignedError(database);
            return;
        }
        database.saveToFile();
        System.out.println("Logging out...");
    }
}
