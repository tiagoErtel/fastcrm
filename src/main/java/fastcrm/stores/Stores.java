package fastcrm.stores;

public class Stores {
    private String id;
    private String name;
    private String parent_store;

    public Stores() {}

    public Stores(String id, String name, String parent_store) {
        this.id = id;
        this.name = name;
        this.parent_store = parent_store;
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

    public String getParent_store() {
        return parent_store;
    }

    public void setParent_store(String parent_store) {
        this.parent_store = parent_store;
    }
}
