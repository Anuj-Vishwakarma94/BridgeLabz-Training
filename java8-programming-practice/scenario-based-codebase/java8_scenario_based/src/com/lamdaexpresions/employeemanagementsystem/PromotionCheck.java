package com.lamdaexpresions.employeemanagementsystem;

@FunctionalInterface
public interface PromotionCheck {
    boolean isEligible(int experience);
}
