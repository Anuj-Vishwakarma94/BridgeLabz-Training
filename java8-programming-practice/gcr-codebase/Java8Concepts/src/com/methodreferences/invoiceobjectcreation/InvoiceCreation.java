package com.methodreferences.invoiceobjectcreation;

import java.util.*;
import java.util.stream.Collectors;

public class InvoiceCreation {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        // Constructor reference
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
