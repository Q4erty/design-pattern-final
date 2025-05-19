package command;

import composite.Category;
import composite.CategoryComponent;

import java.util.List;
import java.util.Scanner;

public class ManageCategoriesCommand implements Command {
    private final CategoryComponent rootCategory;

    public ManageCategoriesCommand(CategoryComponent rootCategory) {
        this.rootCategory = rootCategory;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Category Management ===");

        CategoryComponent selected = selectParentCategory(scanner, rootCategory, "");

        System.out.print("Enter the name of the new category: ");
        String name = scanner.nextLine().trim();
        ((Category) selected).add(new Category(name));
        System.out.println("✅ Category added!");
    }

    private CategoryComponent selectParentCategory(Scanner scanner,
                                                   CategoryComponent current,
                                                   String prefix) {
        System.out.println(prefix + "Current category: " + current.getName());

        if (current instanceof Category) {
            List<CategoryComponent> children = ((Category) current).getChildren();

            for (int i = 0; i < children.size(); i++) {
                System.out.println(prefix + (i + 1) + ". " + children.get(i).getName());
            }

            System.out.println(prefix + "0. Select this category");
            System.out.print(prefix + "Choose a category: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= children.size()) {
                return selectParentCategory(scanner,
                        children.get(choice - 1),
                        prefix + "  ");
            }
        }
        return current;
    }

    @Override
    public String getName() {
        return "Category Management";
    }
}
