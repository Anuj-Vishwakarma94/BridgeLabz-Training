package com.swiftcart;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {

            System.out.println("\n====== SwiftCart Menu ======");
            System.out.println("1. Add Product");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.println("Select Product Type:");
                    System.out.println("1. Perishable");
                    System.out.println("2. Non-Perishable");
                    System.out.print("Enter: ");
                    int type = sc.nextInt();

                    Product product;

                    if (type == 1)
                        product = new PerishableProduct(name, price, category, qty);
                    else
                        product = new NonPerishableProduct(name, price, category, qty);

                    cart.addProduct(product);

                    System.out.println("✔ Product Added Successfully!");
                    break;

                case 2:
                    cart.showCart();
                    System.out.println("Total (after product discounts): " + cart.getTotalPrice());
                    break;

                case 3:
                    System.out.println("Total Before Coupon: " + cart.getTotalPrice());
                    System.out.print("Enter Coupon Amount: ");
                    double coupon = sc.nextDouble();

                    cart.applyDiscount(coupon);

                    System.out.println("Final Bill: " + cart.generateBill());
                    System.out.println("Checkout Complete — Thank You!");
                    return;

                case 4:
                    System.out.println("Exiting... Thank you for shopping!");
                    return;

                default:
                    System.out.println("Invalid Choice — Try Again!");
            }
            sc.close();
        }
    }
}
