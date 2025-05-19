package command;

import composiite.Category;
import composiite.CategoryComponent;
import factory.TransactionCreator;
import model.Transaction;
import observer.TransactionNotifier;

import java.util.List;
import java.util.Scanner;

public class AddTransactionCommand implements Command {
    private final TransactionRepository repository;
    private final TransactionNotifier notifier;
    private final CategoryComponent categoryRoot;

    public AddTransactionCommand(TransactionRepository repository, TransactionNotifier notifier, CategoryComponent categoryRoot) {
        this.repository = repository;
        this.notifier = notifier;
        this.categoryRoot = categoryRoot;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of transaction (income/expense): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter a category: ");
        CategoryComponent category = selectCategory(scanner);

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
    private CategoryComponent selectCategory(Scanner scanner) {
        return selectCategoryRecursive(scanner, categoryRoot, "");
    }

    private CategoryComponent selectCategoryRecursive(Scanner scanner,
                                                      CategoryComponent current,
                                                      String prefix) {
        System.out.println(prefix + current.getName());
        if (current instanceof Category) {
            List<CategoryComponent> children = ((Category) current).getChildren();
            for (int i = 0; i < children.size(); i++) {
                System.out.printf("%s%d. %s%n", prefix + "  ", i + 1, children.get(i).getName());
            }
            System.out.print(prefix + "Select category (0 for current): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= children.size()) {
                return selectCategoryRecursive(
                        scanner,
                        children.get(choice - 1),
                        prefix + "  "
                );
            }
        }
        return current;
    }
    @Override
    public String getName() {
        return "Add transaction";
    }
}