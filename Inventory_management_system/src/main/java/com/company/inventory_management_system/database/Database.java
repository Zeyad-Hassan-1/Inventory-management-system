/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zeyad
 */
public abstract class Database {

    private String fileName;
    private ArrayList<Record> records;

    public Database(String fileName) {
        this.fileName = fileName;
        records = new ArrayList<>();
        readFromFile();
    }

    public final void readFromFile() {
        File file = new File(this.fileName);

        try (Scanner scanner = new Scanner(file)) {
            records.clear();
            while (scanner.hasNext()) {
                Record record = createRecordFrom(scanner.nextLine());
                if (record != null) {
                    records.add(record);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + this.fileName);
        }
    }

    public final ArrayList<Record> returnAllRecords() {
        return records;
    }

    public final boolean contains(String key) {
        for (Record record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public final Record getRecord(String key) {
        for (Record record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public final void insertRecord(Record record) {
        if (record != null && !contains(record.getSearchKey())) {
            records.add(record);
            System.out.println("Record inserted successfully");
        } else {
            System.out.println("Record is null or already in the database");
        }
    }

    public final boolean deleteRecord(String key) {
        Record record = getRecord(key);
        if (record != null) {
            records.remove(getRecord(key));
            System.out.println("Record deleted successfully");
            return true;
        } else {
            System.out.println("Record not found");
            return false;
        }
    }

    public final void saveToFile() {
        File file = new File(this.fileName);
        try (FileWriter writer = new FileWriter(file)) {
            System.out.println("Saving to file..." + this.fileName);
            for (Record record : records) {
                writer.write(record.lineRepresentation() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving to file: " + this.fileName);
        }
        System.out.println("Saved Successfully!!!"); // just acknowledgement
    }

    public abstract Record createRecordFrom(String line);
}
