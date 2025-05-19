package command;

import strategy.AnalyzerContext;
import strategy.TotalBalanceStrategy;
import strategy.CategoryExpenseStrategy;

import java.util.Scanner;

public class AnalyzeTransactionsCommand implements Command {
    private final TransactionRepository repository;

    public AnalyzeTransactionsCommand(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        AnalyzerContext context = new AnalyzerContext();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the type of analysis:");
        System.out.println("1. Overall balance");
        System.out.println("2. Expenses by category");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> context.setStrategy(new TotalBalanceStrategy());
            case 2 -> context.setStrategy(new CategoryExpenseStrategy());
            default -> {
                System.out.println("Wrong choice.");
                return;
            }
        }

        context.execute(repository.getAll());
    }

    @Override
    public String getName() {
        return "Analyze transactions";
    }
}
