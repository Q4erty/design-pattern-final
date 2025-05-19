import command.*;
import observer.BudgetAlertObserver;
import observer.TransactionNotifier;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionRepository repository = new TransactionRepository();

        TransactionNotifier subject = new TransactionNotifier();
        subject.registerObserver(new BudgetAlertObserver(1000));

        List<Command> commands = new ArrayList<>();
        commands.add(new AddTransactionCommand(repository, subject));
        commands.add(new ShowTransactionsCommand(repository));
        commands.add(new AnalyzeTransactionsCommand(repository));

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
