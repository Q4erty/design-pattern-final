package model;

import composiite.CategoryComponent;

public interface Transaction {
    CategoryComponent category();
    double amount();
    boolean isIncome();
    String getCategoryPath();
}
