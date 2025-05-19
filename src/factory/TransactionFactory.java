package factory;

import composite.CategoryComponent;
import model.Transaction;

public interface TransactionFactory {
    Transaction createTransaction(CategoryComponent category, double amount, String date);
}

