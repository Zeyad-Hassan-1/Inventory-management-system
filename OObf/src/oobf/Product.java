package oobf;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    public enum Category {
        ELECTRONICS, FOOD, CLOTHING, TOYS, OTHER
    }

    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;
    private Category category;

    public Product(String productID, String productName, String manufacturerName,
            String supplierName, int quantity, float price, Category category) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;

        if (quantity < 0) {
            System.out.println(" Quantity cannot be negative Default value (0) used");
        } else {
            this.quantity = quantity;
        }

        this.category = category;

        if (price <= 0) {
            this.price = 1;
            System.out.println(" Invalid price! Default value (1) used.");
        } else {
            this.price = price;
        }
    }

    public static Product createProductFromInput() {
        Scanner in = new Scanner(System.in);

        System.out.println("=== Enter Product Information ===");

        System.out.print("Enter Product ID: ");
        String id = in.nextLine();

        System.out.print("Enter Product Name: ");
        String name = in.nextLine();

        System.out.print("Enter Manufacturer Name: ");
        String manufacturer = in.nextLine();

        System.out.print("Enter Supplier Name: ");
        String supplier = in.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = in.nextInt();

        System.out.print("Enter Price: ");
        float price = in.nextFloat();

        System.out.println("Select Category:");
        System.out.println("1. ELECTRONICS");
        System.out.println("2. FOOD");
        System.out.println("3. CLOTHING");
        System.out.println("4. TOYS");
        System.out.println("5. OTHER");

        System.out.print("Enter Category Number (1-5): ");
        int choice = in.nextInt();

        Category category;
        switch (choice) {
            case 1:
                category = Category.ELECTRONICS;
                break;
            case 2:
                category = Category.FOOD;
                break;
            case 3:
                category = Category.CLOTHING;
                break;
            case 4:
                category = Category.TOYS;
                break;
            case 5:
                category = Category.OTHER;
                break;
            default:
                System.out.println(" Invalid choice! Defaulted to OTHER.");
                category = Category.OTHER;
                break;
        }

        System.out.println(" Product created successfully!\n");
        return new Product(id, name, manufacturer, supplier, quantity, price, category);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
        } else {
            this.quantity = quantity;
            displayInfo();
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        displayInfo();

    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price > 0) {
            this.price = price;
            displayInfo();

        } else {
            System.out.println("Price must be greater than 0.");
        }
    }

    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + ","
                + supplierName + "," + quantity + "," + price + "," + category;
    }

    public void displayInfo() {
        System.out.println("=== Product Details ===");
        System.out.println("ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Manufacturer: " + manufacturerName);
        System.out.println("Supplier: " + supplierName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("------------------------------");
    }

    public String getSearchKey() {
        return productID;
    }

    public float totalValueInStock() {
        System.out.println("totalValueInStock: " + price * quantity  );
    float y = price * quantity ; 
    return y ; 
    }

    public boolean sellQuantity(int amount) {
        if (amount > 0 && quantity >= amount) {
            quantity -= amount;

            System.out.println("Sold " + amount + " units. Remaining: " + quantity);
            return true;
        } else {
            System.out.println(" Not enough stock to sell " + amount + " units.");
            return false;
        }
    }

    public void addQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Added " + amount + " units. New quantity: " + quantity);

        } else {
            System.out.println(" Invalid amount. Must be greater than zero.");
        }
    }

    public static boolean isProductIDUnique(String newID, ArrayList<Product> products) {
        if (newID == null || products == null) {
            return false;
        }
        for (Product p : products) {
            String key = p.getSearchKey();
            if (key != null && key.equalsIgnoreCase(newID)) {
                return false;
            }
        }
        return true;
    }

}
