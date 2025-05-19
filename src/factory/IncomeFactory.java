package factory;

import model.Income;
import model.Transaction;

public class IncomeFactory implements TransactionFactory {
    @Override
    public Transaction createTransaction(String category, double amount, String date) {
        return new Income(category, amount, date);
    }
}

