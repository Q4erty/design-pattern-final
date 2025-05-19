package composiite;

public class SubCategory implements CategoryComponent {
    private final String name;
    private CategoryComponent parent;

    public SubCategory(String name) {
        this.name = name;
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "- " + name);
    }

    @Override
    public String toString() {
        return getFullPath();
    }
}
