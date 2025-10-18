/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.role;

/**
 *
 * @author Hazem
 */
public abstract class Role {
    protected void noDatabaseAssignedError()
    {
        System.out.println("Database should be instantiated and set first");
    }
    
    protected void noDatabaseAssignedError(String databaseType)
    {
        System.out.println(databaseType + " database should be instantiated and set first");
    }
    
    public abstract void logout();
}
