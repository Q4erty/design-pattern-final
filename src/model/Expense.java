package model;

public class Expense implements Transaction {
    private String category;
    private double amount;
    private String date;

    public Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void printDetails() {
        System.out.println("[Expense] " + date + " | " + category + " | -" + amount);
    }

    @Override
    public boolean isIncome() {
        return false;
    }

    @Override
    public String toString() {
        return "[Expense] Category: " + category + ", Amount: " + amount + ", Date: " + date;
    }
}
