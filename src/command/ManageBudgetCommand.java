package command;

import observer.BudgetAlertObserver;

import java.util.Scanner;

public class ManageBudgetCommand implements Command {
    private final BudgetAlertObserver observer;

    public ManageBudgetCommand(BudgetAlertObserver observer) {
        this.observer = observer;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Budget Management ===");
        System.out.printf("Current limit: %.2f%n", observer.getCurrentLimit());
        System.out.println("1. Set a new limit");
        System.out.println("2. Reset to default value");
        System.out.print("Choose an action: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter the new limit: ");
                double newLimit = scanner.nextDouble();
                scanner.nextLine();
                observer.setMonthlyLimit(newLimit);
                System.out.println("✅ Limit updated!");
            }
            case 2 -> {
                observer.resetToDefault();
                System.out.println("✅ Limit reset to default value!");
            }
            default -> System.out.println("❌ Invalid choice");
        }
    }

    @Override
    public String getName() {
        return "Budget Management";
    }
}
