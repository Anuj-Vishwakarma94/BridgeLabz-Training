package com.objectmodeling;
import java.util.Scanner;
public class EcommercePlatform {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Customer2 customer = new Customer2("Aryan");

        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mouse", 800);

        Order order = new Order(101);

        order.addProduct(product1);
        order.addProduct(product2);

        customer.placeOrder(order);
        order.showOrderDetails();
        sc.close();
    }
}
