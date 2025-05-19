package factory;

import composiite.CategoryComponent;
import model.Transaction;

public class TransactionCreator {
    public static Transaction create(String type, CategoryComponent category, double amount, String date) {
        TransactionFactory factory = switch (type.toLowerCase()) {
            case "income" -> new IncomeFactory();
            case "expense" -> new ExpenseFactory();
            default -> throw new IllegalArgumentException("Unknown transaction type: " + type);
        };
        return factory.createTransaction(category, amount, date);
    }
}

