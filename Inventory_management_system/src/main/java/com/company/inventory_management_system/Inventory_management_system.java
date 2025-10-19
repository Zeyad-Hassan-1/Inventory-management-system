/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.company.inventory_management_system;

import com.company.inventory_management_system.database.CustomerProductDatabase;
import com.company.inventory_management_system.database.ProductDatabase;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author zeyad
 */
public class Inventory_management_system {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ProductDatabase productsDatabase = new ProductDatabase("products.txt");
        Product product = new Product("123","efes","dsfrd","efsre",-5,0.5f);
        productsDatabase.insertRecord(product);
        productsDatabase.saveToFile();
        productsDatabase.readFromFile();
        System.out.println(productsDatabase.returnAllRecords().toArray()[0]);

        scanner.close();
    }
}
