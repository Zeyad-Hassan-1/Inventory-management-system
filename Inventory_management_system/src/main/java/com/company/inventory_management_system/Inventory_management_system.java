/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.company.inventory_management_system;

import com.company.inventory_management_system.database.EmployeeUserDatabase;
import com.company.inventory_management_system.role.AdminRole;
import com.company.inventory_management_system.role.EmployeeRole;
import com.company.inventory_management_system.role.Role;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author zeyad
 */
public class Inventory_management_system {

    private static int mainMenu()
    {
        Scanner scan = new Scanner(System.in);
        String mainMenu = "Inventory Management System\n---------------------------\nChoose one of the following options to proceed\n(1)Admin Login\n(2)Employee Login\n(3)Exit Program\nEnter Choice Index:";
        while(true)
        {
            System.out.println(mainMenu);
            String inputBuffer = scan.nextLine();
            if(Validation.isPositiveInt(inputBuffer))
            {
                int choice = Integer.parseInt(inputBuffer);
                if(choice<=3&&choice>=1)
                {
                    return choice;
                } 

            }
            System.out.println("Invalid Input, Please Try again...");
        }
    }
    
    private static void roleHandler(AdminRole role)
    {
        Scanner scan = new Scanner(System.in);
        String inputBuffer;
        int isConfirmation;
        while(true)
        {
            System.out.println("Do you want to change the source file of the employees database? (y/n)");
            isConfirmation = Validation.isConfirmationResponse(scan.nextLine());
            if(isConfirmation==1)
            {
                System.out.println("Enter new source file: ");
                inputBuffer = scan.nextLine();
                if(Validation.isAlphabetic(inputBuffer, "File Name"))
                {
                    EmployeeUserDatabase newDB = new EmployeeUserDatabase(inputBuffer);
                    role.setDatabase(newDB);
                    break;
                }
                continue;
            }
            else if(isConfirmation==0)
            {
                break;
            }

            // else it will continue the loop & display the following message                
            System.out.println("Invalid Input, Please Try again...");
        }
        
        String adminMenu = "Admin Operations\n---------------------------\nChoose one of the following options to proceed\n(1)Add employee\n(2)Get list of employees\n(3)Remove employee\n(4)Log out\nEnter Choice Index:";
        int choice;
        isConfirmation = 1;
        while(isConfirmation==1)
        {
            while(true)
            {
                System.out.println(adminMenu);
                inputBuffer = scan.nextLine();
                if(Validation.isPositiveInt(inputBuffer))
                {
                    choice = Integer.parseInt(inputBuffer);
                    if(choice<=4&&choice>=1)
                    {
                        break;
                    } 

                }
                System.out.println("Invalid Input, Please Try again...");
            }
            switch(choice)
            {
                case 1://Add Employee
                    System.out.println("Enter Employee Name:");
                    String name = scan.nextLine().trim();
                    System.out.println("Enter Employee Id:");
                    String id = scan.nextLine().trim();
                    System.out.println("Enter email:");
                    String email = scan.nextLine().trim();
                    System.out.println("Enter Address");
                    String address = scan.nextLine().trim();
                    System.out.println("Enter Phone Number:");
                    String phoneNum = scan.nextLine().trim();
                    if(Validation.isAlphabetic(name, "name")&&Validation.validEmail(email)&&
                       Validation.validPhone(phoneNum)&&Validation.isAlphabetic(id.substring(0, 1), "Id")&&
                       Validation.isPositiveInt(id.substring(1))&&Validation.isAlphabetic(address, "Address"))
                    {
                        role.addEmployee(id, name, email, address, phoneNum);
                    }
                    break;
                
                case 2://Get Employee List
                    EmployeeUser[] employeesList = role.getListOfEmployees();
                    for(EmployeeUser employee:employeesList)
                    {
                        System.out.println("------------------------");
                        System.out.println("Name: " + employee.getName());
                        System.out.println("ID: " + employee.getSearchKey());
                        System.out.println("Email: " + employee.getEmail());
                        System.out.println("Address: " + employee.getAddress());
                        System.out.println("Phone Number: " + employee.getPhoneNumber());
                        System.out.println("------------------------");
                    }
                    System.out.println("Total Number of Employees: " + employeesList.length);
                    break;
                
                case 3://Remove Employee
                    System.out.println("Enter Employee Id:");
                    String searchKey = scan.nextLine().trim();
                    role.removeEmployee(searchKey);
                    break;
                    
                case 4:
                default:
                    role.logout();
                    return;
            }
            
            do
            {
                System.out.println("Do you wish to do more operations?");
                isConfirmation = Validation.isConfirmationResponse(scan.nextLine());
            }while(isConfirmation==-1);
            
        }
        role.logout();
        
    }
    
   
    
    
    
    private static void roleHandler(EmployeeRole role)
{
    Scanner scan = new Scanner(System.in);
    String inputBuffer;
    int choice;
    int isConfirmation = 1; // 1 = yes, 0 = no

    // Employee Menu
    String employeeMenu = "Employee Operations\n"
            + "---------------------------\n"
            + "(1) Add product\n"
            + "(2) return all products then display\n"
            + "(3) return all purchasing products then display\n"
            + "(4) purchase product\n"
            + "(5) return product\n"
            + "(6) apply payment\n"
            + "(7) logout\n"
            + "Enter Choice Index:";

    
    while (isConfirmation == 1)
    {
        
        while (true)
        {
            System.out.println(employeeMenu);
            inputBuffer = scan.nextLine();

            if (Validation.isPositiveInt(inputBuffer))
            {
                choice = Integer.parseInt(inputBuffer);
                if (choice >= 1 && choice <= 7)
                    break;
            }

            System.out.println("Invalid Input, Please Try again...");
        }

        String customerSSN,productId,productName,manufacturerName,supplierName,quantity,price,purchaseDateString;
        LocalDate purchaseDate;
        switch (choice)
        {
            
            case 1:
                // Add a new product
                System.out.println("Enter Product Id: ");
                productId = scan.nextLine().trim();
                System.out.println("Enter Product Name: ");
                productName = scan.nextLine().trim();
                System.out.println("Enter Manufacturer Name: ");
                manufacturerName = scan.nextLine().trim();
                System.out.println("Enter Supplier Name: ");
                supplierName = scan.nextLine().trim();
                System.out.println("Enter Quantity: ");
                boolean flag1 = true;
                do {
                    if (!flag1){
                        System.out.println("Invalid Quantity, Please Try again...");
                    }
                     quantity = scan.nextLine().trim();
                    flag1 = false;
                }while (!Validation.isPositiveInt(quantity));
                flag1 = true;
                System.out.println("Enter Price: ");
                do {
                    if (!flag1){
                        System.out.println("Invalid Price, Please Try again...");
                    }
                     price = scan.nextLine().trim();
                    flag1 = false;
                }while (!Validation.isPositiveFloat(price));
                role.addProduct(productId,productName,manufacturerName,supplierName,Integer.parseInt(quantity),Float.parseFloat(price));
                break;

            case 2:
                // return all products then display
                Product[] products = role.getListOfProducts();
                for (Product product : products){
                    System.out.println(product.lineRepresentation());
                }
                break;

            case 3:
                CustomerProduct[] customerProducts = role.getListOfPurchasingOperations();
                for (CustomerProduct customerProduct : customerProducts){
                    System.out.println(customerProduct.lineRepresentation());
                }

                break;

            case 4:
                // purchase product
                System.out.print("Enter Customer SSN: ");
                customerSSN = scan.nextLine().trim();

                System.out.print("Enter Product ID: ");
                productId = scan.nextLine().trim();
                // Create a new CustomerProduct object
                LocalDate date = LocalDate.now();
                CustomerProduct newPurchase = new CustomerProduct(customerSSN, productId, date);
                role.purchaseProduct(customerSSN, productId, date);
                System.out.println("Purchase recorded successfully for customer " + customerSSN);

                break;

            case 5:
                //return product
                System.out.print("Enter Customer SSN: ");
                customerSSN = scan.nextLine().trim();

                System.out.print("Enter Product ID: ");
                productId = scan.nextLine().trim();
                LocalDate returnDate = LocalDate.now();

                System.out.print("Enter Purchase Date (dd-MM-yyyy): ");
                boolean flagg = true;
                do {
                    if (!flagg){
                        System.out.println("Invalid Date Format, Please Try again...");
                    }
                    purchaseDateString = scan.nextLine().trim();
                    flagg = false;

                }while (!Validation.isValidDate(purchaseDateString));
                purchaseDate = LocalDate.parse(purchaseDateString,CustomerProduct.getFORMATTER());
                role.returnProduct(customerSSN, productId, purchaseDate, returnDate);
                break;
            case 6:
                //apply payment
                System.out.print("Enter Customer SSN: ");
                customerSSN = scan.nextLine().trim();

                System.out.print("Enter Purchase Date (dd-MM-yyyy): ");
                boolean flag = true;
                do {
                    if (!flag){
                        System.out.println("Invalid Date Format, Please Try again...");
                    }
                    purchaseDateString = scan.nextLine().trim();
                    flag = false;
                    
                }while (!Validation.isValidDate(purchaseDateString));
                purchaseDate = LocalDate.parse(purchaseDateString,CustomerProduct.getFORMATTER());
                role.applyPayment(customerSSN, purchaseDate);
                break;
            case 7:
            default:
                role.logout();
                return;
        }

        
        do
        {
            System.out.print("Do you want to perform more operations? (y/n): ");
            isConfirmation = Validation.isConfirmationResponse(scan.nextLine());
        } while (isConfirmation == -1);
    }

    
    role.logout();
}



        
    
    
    public static void main(String[] args){
        
        while(true)
        {
            Role role;
            switch(mainMenu())
            {
                case 1:
                    role = new AdminRole();
                    roleHandler((AdminRole)role);
                    break;
                case 2:
                    role = new EmployeeRole();
                    roleHandler((EmployeeRole)role);
                    break;
                case 3:
                default:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
