package strategy;

import model.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryExpenseStrategy implements AnalysisStrategy {
    @Override
    public void analyze(List<Transaction> transactions) {
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {
            if (!t.isIncome()) {
                String path = t.getCategoryPath();
                categoryTotals.put(path,
                        categoryTotals.getOrDefault(path, 0.0) + t.amount());
            }
        }

        if (categoryTotals.isEmpty()) {
            System.out.println("There is no data on expenditures.");
        } else {
            System.out.println("Expenditures by category:");
            categoryTotals.forEach((category, total) ->
                    System.out.println("- " + category + ": " + total));
        }
    }
}
