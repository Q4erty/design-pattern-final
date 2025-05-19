package model;

import composiite.CategoryComponent;

public record Income(CategoryComponent category, double amount, String date) implements Transaction {

    @Override
    public boolean isIncome() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("[Income] Category: %s, Amount: %.2f, Date: %s",
                category.getFullPath(), amount, date);
    }

    @Override
    public String getCategoryPath() {
        return category().getFullPath();
    }
}

