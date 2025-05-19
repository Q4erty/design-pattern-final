import command.*;
import composiite.Category;
import composiite.CategoryComponent;
import composiite.SubCategory;
import observer.BudgetAlertObserver;
import observer.TransactionNotifier;

import java.util.*;

public class Main {
    private static CategoryComponent createCategoryStructure() {
        Category root = new Category("All Categories");

        Category expenses = new Category("Expenses");
        Category food = new Category("Food");
        food.add(new SubCategory("Groceries"));
        food.add(new SubCategory("Restaurants"));
        expenses.add(food);

        Category transport = new Category("Transport");
        transport.add(new SubCategory("Fuel"));
        transport.add(new SubCategory("Public Transport"));
        expenses.add(transport);

        root.add(expenses);

        Category income = new Category("Income");
        income.add(new SubCategory("Salary"));
        income.add(new SubCategory("Freelance"));
        root.add(income);

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryComponent categoryRoot = createCategoryStructure();
        TransactionRepository repository = new TransactionRepository();

        TransactionNotifier subject = new TransactionNotifier();
        BudgetAlertObserver budgetObserver = new BudgetAlertObserver(1000);
        subject.registerObserver(budgetObserver);

        List<Command> commands = new ArrayList<>();
        commands.add(new AddTransactionCommand(repository, subject, categoryRoot));
        commands.add(new ShowTransactionsCommand(repository));
        commands.add(new AnalyzeTransactionsCommand(repository));
        commands.add(new ManageBudgetCommand(budgetObserver));
        commands.add(new ManageCategoriesCommand(categoryRoot));

        while (true) {
            System.out.println("\n=== Financial accounting ===");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getName());
            }
            System.out.println("0. Exit");
            System.out.print("Choose an action:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice < 1 || choice > commands.size()) {
                System.out.println("❌ Wrong selection. Try again.");
                continue;
            }

            Command command = commands.get(choice - 1);
            command.execute();
        }
    }
}
