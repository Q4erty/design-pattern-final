package observer;

import model.Transaction;

public class BudgetAlertObserver implements Observer {
    private double monthlyLimit;
    private double currentTotal = 0;
    private final double defaultLimit;

    public BudgetAlertObserver(double defaultLimit) {
        this.defaultLimit = defaultLimit;
        this.monthlyLimit = defaultLimit;
    }

    public void setMonthlyLimit(double newLimit) {
        this.monthlyLimit = newLimit;
    }

    public void resetToDefault() {
        this.monthlyLimit = defaultLimit;
    }

    public double getCurrentLimit() {
        return monthlyLimit;
    }

    @Override
    public void update(Transaction transaction) {
        if (!transaction.isIncome()) {
            currentTotal += transaction.amount();
            if (currentTotal > monthlyLimit) {
                System.out.printf("⚠️ Limit exceeded! Current expenses: %.2f (Limit: %.2f)%n",
                        currentTotal, monthlyLimit);
            }
        }
    }
}