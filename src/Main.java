import command.*;
import composite.Category;
import composite.CategoryComponent;
import composite.SubCategory;
import observer.BudgetAlertObserver;
import observer.TransactionNotifier;

import java.util.*;

public class Main {
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

        CommandMenu menu = new CommandMenu("Financial accounting");
        for (Command cmd : commands) {
            menu.addCommand(cmd);
        }

        menu.show(scanner);
    }

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
}
