package com.loanbuddy;

public abstract class LoanApplication implements IApprovable {

    protected Applicant applicant;
    protected double interestRate;
    protected int termMonths;

    private boolean approved = false;

    public LoanApplication(Applicant applicant, double interestRate, int termMonths) {
        this.applicant = applicant;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
    }

    private boolean internalApprovalCheck() {
        return applicant.getCreditScore() >= 750
                && applicant.getIncome() >= (applicant.getLoanAmount() * 0.05);
    }

    @Override
    public boolean approveLoan() {
        approved = internalApprovalCheck();
        return approved;
    }

    public boolean isApproved() {
        return approved;
    }

    @Override
    public double calculateEMI() {

        double P = applicant.getLoanAmount();
        double R = (interestRate / 12) / 100;
        int N = termMonths;

        double numerator = P * R * Math.pow(1 + R, N);
        double denominator = Math.pow(1 + R, N) - 1;

        return numerator / denominator;
    }
}
