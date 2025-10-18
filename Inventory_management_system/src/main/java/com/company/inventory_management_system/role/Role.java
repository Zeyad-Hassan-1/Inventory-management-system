/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.role;

import com.company.inventory_management_system.database.Database;

/**
 *
 * @author Hazem
 */
public abstract class Role {
    protected void noDatabaseAssignedError(Database D)
    {
        System.out.println(D.getClass().getSimpleName() + " should be instantiated and set first");
    }
    
    public abstract void logout();
}
