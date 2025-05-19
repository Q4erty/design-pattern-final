package model;

public class Income implements Transaction {
    private String category;
    private double amount;
    private String date;

    public Income(String category, double amount, String date) {
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
        System.out.println("[Income] " + date + " | " + category + " | +" + amount);
    }

    @Override
    public boolean isIncome() {
        return true;
    }

    @Override
    public String toString() {
        return "[Income] Category: " + category + ", Amount: " + amount + ", Date: " + date;
    }
}

