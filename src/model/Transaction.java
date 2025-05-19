package model;

import composite.CategoryComponent;

public interface Transaction {
    CategoryComponent category();
    double amount();
    boolean isIncome();
    String getCategoryPath();
}
