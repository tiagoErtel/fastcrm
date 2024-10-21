package fastcrm.product;

public class Product {
    private String id;
    private String name;
    private String description;
    private String group;

    public Product() {}

    public Product(String id, String name, String description, String group) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
