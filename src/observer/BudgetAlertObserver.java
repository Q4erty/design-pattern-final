package observer;

import model.Transaction;

public class BudgetAlertObserver implements Observer {
    private double monthlyLimit;

    public BudgetAlertObserver(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    private double currentTotal = 0;

    @Override
    public void update(Transaction transaction) {
        if (!transaction.isIncome()) {
            currentTotal += transaction.getAmount();
            if (currentTotal > monthlyLimit) {
                System.out.println("⚠️ Warning. The monthly spending limit has been exceeded: " + (currentTotal - monthlyLimit));
            }
        }
    }
}
