package javamentor.aprel19.ecommerceapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Map<String, Product> map = new HashMap<>();

            Product product1 = new Product("P001", "Espresso", 4.50, "available");
            Product product2 = new Product("P002", "Latte", 5.00, "out_of_stock");
            Product product3 = new Product("P003", "Cappuccino", 5.25, "available");

            map.put(product1.getId(),product1);
            map.put(product2.getId(),product2);
            map.put(product3.getId(),product3);

            Scanner scanner = new Scanner(System.in);
            boolean running =true;
            while (running) {
                System.out.println("\n==== PRODUCT MENU ====");
                System.out.println("1. Add Product");
                System.out.println("2. List All Products");
                System.out.println("3. Update Product Status");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter Product ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Product Price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter Product Status (available / out_of_stock / discontinued): ");
                        String status = scanner.nextLine();

                        Product product = new Product(status, name, price, id);

                        map.put(product.getId(), product);
                        System.out.println("Product added!");
                        break;


                    case "2":
                        if (map.isEmpty()) {
                            System.out.println("No products available.");
                        } else {
                            System.out.println("\n--- Product List ---");
                            for (Map.Entry<String, Product> entry : map.entrySet()) {
                                System.out.println(entry.getValue());
                            }
                        }
                        break;
                    case "3":
                        System.out.print("Enter Product ID to update: ");
                        String UptadeID = scanner.nextLine();
                        Product toUpdate = map.get(UptadeID);
                        if (toUpdate != null) {
                            System.out.println("Enter new status: ");
                            String newStatus = scanner.nextLine();
                            toUpdate.newStatus(newStatus);
                            System.out.println("Status updated.");
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;
                    case "4":
                        System.out.print("Enter Product ID to delete: ");
                        String deleteID = scanner.nextLine();

                        if (map.remove(deleteID) != null) {
                            map.remove(deleteID);
                            System.out.println("Product deleted.");
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;
                    case "5":
                        running = false;
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
}
