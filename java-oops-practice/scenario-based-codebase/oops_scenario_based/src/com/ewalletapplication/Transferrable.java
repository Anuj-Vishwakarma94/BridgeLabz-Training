package com.ewalletapplication;
public interface Transferrable {
    boolean transferTo(User receiver, double amount);
}
