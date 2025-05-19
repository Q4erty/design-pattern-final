package composiite;

import java.util.ArrayList;
import java.util.List;

public class Category implements CategoryComponent {
    private String name;
    private List<CategoryComponent> children = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void add(CategoryComponent component) {
        children.add(component);
    }

    public void remove(CategoryComponent component) {
        children.remove(component);
    }

    public List<CategoryComponent> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "[+] " + name);
        for (CategoryComponent child : children) {
            child.print(prefix + "  ");
        }
    }
}
