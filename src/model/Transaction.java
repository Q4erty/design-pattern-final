package model;

public interface Transaction {
    String getCategory();
    double getAmount();
    String getDate();
    void printDetails();
    boolean isIncome();
}
