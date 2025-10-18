# Inventory Management System – CC272 Programming II  
**Alexandria University – Faculty of Engineering**  
*Fall 2025/2026*

This Java application implements a fully **object-oriented Inventory Management System** for a retail store, supporting two user roles: **Admins** and **Employees**. The system uses **abstraction, inheritance, and polymorphism** to eliminate code duplication and ensure maintainable, scalable code.

All data is persisted in plain-text CSV files, and the architecture follows a clean separation between **data entities**, **database logic**, and **user roles**.

---

## 🌟 Features

### 🔐 Admin Role
- Add new employees  
- Remove existing employees  
- Data stored in `Employees.txt`

### 👨‍💼 Employee Role
- Add new products to inventory  
- Sell products to customers (decrements stock)  
- Process returns **within 14 days** of purchase  
- Apply payments to customer purchases  
- Data stored in:
  - `Products.txt`
  - `CustomersProducts.txt`

### ⏳ Return Policy
A return is accepted **only if**:
- Return date ≥ purchase date  
- Product exists in inventory  
- Purchase record exists  
- Return occurs **within 14 days** of purchase  
On successful return, product quantity is increased and the purchase record is removed.

---

## 🧱 OOP Design

### 🔁 Common Interface: `Record`
All data entities implement the `Record` interface, which defines:
- `String getSearchKey()` → unique identifier (e.g., employee ID, product ID, or composite key)
- `String lineRepresentation()` → CSV format for file storage

### 📦 Abstract Base Class: `Database`
- Contains a collection of `Record` objects
- Provides shared file I/O and CRUD logic (read, save, search, insert, delete)
- **Not generic**—uses polymorphism via the `Record` interface

### 🏗️ Concrete Database Classes
Each extends `Database` and handles type-specific logic:
- `EmployeeUserDatabase` → manages `EmployeeUser` records
- `ProductDatabase` → manages `Product` records
- `CustomerProductDatabase` → manages `CustomerProduct` records

### 👥 Entity Classes
- `EmployeeUser` → employee info (ID, name, email, etc.)
- `Product` → product details (ID, name, quantity, price, etc.)
- `CustomerProduct` → purchase record (customer SSN, product ID, date, payment status)

---

## 🖼️ UML Class Diagram

<img width="1297" height="595" alt="Inventory Database System" src="https://github.com/user-attachments/assets/6150017e-091b-4336-a276-e60c0d52975d" />

---
