package com.objectmodeling;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    String bankname;
    ArrayList<Customer> customerlist = new ArrayList<>();

    Bank(String bankname) {
        this.bankname = bankname;
    }

    void openAccount(Customer customer) {
        customerlist.add(customer);
        System.out.println("Account opened for " + customer.customername + " in " + bankname);
    }

    void showCustomers() {
        System.out.println("Customers in " + bankname + ":");
        for (Customer customer : customerlist) {
            System.out.println(customer.customername);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank hdfcBank = new Bank("HDFC Bank");
        Bank sbiBank = new Bank("SBI Bank");

        Customer customer1 = new Customer("Aryan", 25000);
        Customer customer2 = new Customer("Rahul", 40000);

        hdfcBank.openAccount(customer1);
        hdfcBank.openAccount(customer2);

        sbiBank.openAccount(customer1);

        customer1.viewBalance();
        customer2.viewBalance();

        hdfcBank.showCustomers();
        sbiBank.showCustomers();
        sc.close();
    }
}
