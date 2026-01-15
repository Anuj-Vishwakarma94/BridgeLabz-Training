package com.payxpress;
public interface IPayable {
    void pay(int daysLate);
    void sendReminder();
}
