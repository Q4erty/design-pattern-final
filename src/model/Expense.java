package model;

import composiite.CategoryComponent;

public record Expense(CategoryComponent category, double amount, String date) implements Transaction {

    @Override
    public boolean isIncome() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("[Expense] Category: %s, Amount: %.2f, Date: %s",
                category.getFullPath(), amount, date);
    }

    @Override
    public String getCategoryPath() {
        return category().getFullPath();
    }
}
