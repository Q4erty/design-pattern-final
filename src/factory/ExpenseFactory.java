package factory;

import model.Expense;
import model.Transaction;

public class ExpenseFactory implements TransactionFactory {
    @Override
    public Transaction createTransaction(String category, double amount, String date) {
        return new Expense(category, amount, date);
    }
}
