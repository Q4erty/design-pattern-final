package strategy;

import java.util.List;
import model.Transaction;

public interface AnalysisStrategy {
    void analyze(List<Transaction> transactions);
}
