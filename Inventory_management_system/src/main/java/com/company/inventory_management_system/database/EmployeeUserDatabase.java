/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.database;

import com.company.inventory_management_system.admin_role.EmployeeUser;

/**
 *
 * @author zeyad
 */
public class EmployeeUserDatabase extends Database{

    public EmployeeUserDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Record createRecordFrom(String line) {
        if(line == null){
            System.out.println("please input the data separated by ,");
            return null;
        }
        String[] fields = line.replace(" ","").split(",");
        if(fields.length != 5){
            System.out.println("Invalid line input");
            return  null;
        }
        return  new EmployeeUser(fields[0],fields[1],fields[2],fields[3],fields[4]);
    }
    
    
    
}
