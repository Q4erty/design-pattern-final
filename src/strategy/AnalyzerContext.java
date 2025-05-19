package strategy;

import model.Transaction;

import java.util.List;

public class AnalyzerContext {
    private AnalysisStrategy strategy;

    public void setStrategy(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(List<Transaction> transactions) {
        if (strategy == null) {
            System.out.println("No analysis strategy has been chosen.");
            return;
        }
        strategy.analyze(transactions);
    }
}
