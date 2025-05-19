package command;

import factory.TransactionCreator;
import model.Transaction;
import observer.TransactionNotifier;

import java.util.Scanner;

public class AddTransactionCommand implements Command {
    private TransactionRepository repository;
    private TransactionNotifier notifier;

    public AddTransactionCommand(TransactionRepository repository, TransactionNotifier notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of transaction (income/expense): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter a category: ");
        String category = scanner.nextLine();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the date (in the format YYYY-MM-DD): ");
        String date = scanner.nextLine();

        try {
            Transaction transaction = TransactionCreator.create(type, category, amount, date);
            repository.add(transaction);
            notifier.notifyObservers(transaction);
            System.out.println("✅ Transaction added.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Add transaction";
    }
}