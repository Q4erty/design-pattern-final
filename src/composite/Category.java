package composite;

import java.util.ArrayList;
import java.util.List;

public class Category implements CategoryComponent {
    private final String name;
    private final List<CategoryComponent> children = new ArrayList<>();
    private CategoryComponent parent;

    public Category(String name) {
        this.name = name;
    }

    public void add(CategoryComponent component) {
        if (children.stream().anyMatch(c -> c.getName().equals(component.getName()))) {
            throw new IllegalArgumentException("A category with that name already exists!");
        }
        component.setParent(this);
        children.add(component);
    }

    @Override
    public String getFullPath() {
        if (parent != null) {
            return parent.getFullPath() + "/" + name;
        }
        return name;
    }

    @Override
    public void setParent(CategoryComponent parent) {
        this.parent = parent;
    }

    @Override
    public CategoryComponent getParent() {
        return parent;
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
    @Override
    public String toString() {
        return getFullPath();
    }

}
