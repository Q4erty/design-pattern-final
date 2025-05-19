package factory;

import model.Transaction;

public interface TransactionFactory {
    Transaction createTransaction(String category, double amount, String date);
}

