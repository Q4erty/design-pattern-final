package strategy;

import model.Transaction;
import java.util.List;

public class TotalBalanceStrategy implements AnalysisStrategy {
    @Override
    public void analyze(List<Transaction> transactions) {
        double income = 0;
        double expenses = 0;

        for (Transaction t : transactions) {
            if (t.isIncome()) income += t.getAmount();
            else expenses += t.getAmount();
        }

        System.out.printf("Income: %.2f \nExpense: %.2f \nBalance: %.2f \n", income, expenses, income - expenses);
    }
}

