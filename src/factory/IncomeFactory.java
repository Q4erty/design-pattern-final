package factory;

import composite.CategoryComponent;
import model.Income;
import model.Transaction;

public class IncomeFactory implements TransactionFactory {
    @Override
    public Transaction createTransaction(CategoryComponent category, double amount, String date) {
        return new Income(category, amount, date);
    }
}

