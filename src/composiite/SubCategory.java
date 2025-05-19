package composiite;

public class SubCategory implements CategoryComponent {
    private String name;

    public SubCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "- " + name);
    }
}
