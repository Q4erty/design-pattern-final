package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandMenu {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            for (int i = 0; i < commands.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, commands.get(i).getName());
            }
            System.out.println("0. Exit");
            System.out.print("Choose command: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice > 0 && choice <= commands.size()) {
                commands.get(choice - 1).execute();
            } else {
                System.out.println("Invalid input.");
            }
        }
    }
}
