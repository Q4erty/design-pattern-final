package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandMenu {
    private final List<Command> commands = new ArrayList<>();
    private final String menuTitle;

    public CommandMenu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void show(Scanner scanner) {
        while (true) {
            System.out.println("\n=== " + menuTitle + " ===");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getName());
            }
            System.out.println("0. Exit");
            System.out.print("Choose an action: ");
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