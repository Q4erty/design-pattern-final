package composiite;

public interface CategoryComponent {
    String getName();
    void print(String prefix);
    String getFullPath();
    void setParent(CategoryComponent parent);
    CategoryComponent getParent();
}
