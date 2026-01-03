package com.ewallet_application;
public interface Transferrable {
    boolean transferTo(User receiver, double amount);
}
