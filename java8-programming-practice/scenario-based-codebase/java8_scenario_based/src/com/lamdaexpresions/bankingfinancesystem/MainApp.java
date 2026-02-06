package com.lamdaexpresions.bankingfinancesystem;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Account a1 = new Account(101, "Anuj", 15000);
        Account a2 = new Account(102, "Andrew", 8000);

        // 1. Minimum balance check (min 5000)
        MinimumBalanceCheck mb = bal -> bal >= 5000;
        System.out.println("Minimum Balance Maintained: " + mb.check(a1.balance));

        // 2. Simple Interest
        InterestCalculator si = (p, r, t) -> (p * r * t) / 100;
        System.out.println("Simple Interest: " + si.calculate(10000, 5, 2));

        // 3. Withdrawal validation
        WithdrawalCheck wc = (bal, amt) -> amt <= bal;
        System.out.println("Withdrawal Allowed: " + wc.isValid(a1.balance, 4000));

        // 4. Print account details
        System.out.println("\nAccount Details:");
        List<Account> list = Arrays.asList(a1, a2);
        list.forEach(acc -> System.out.println(acc));

        // 5. Compare two account balances
        Comparator<Account> compareBalance =
                (x, y) -> Double.compare(x.balance, y.balance);

        System.out.println("\nBalance Comparison Result: "
                + compareBalance.compare(a1, a2));
    }
}
