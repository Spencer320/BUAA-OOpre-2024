public class Item {
    private final String id;
    private final String name;
    private final int ce;

    public Item(String id, String name, int ce) {
        this.id = id;
        this.name = name;
        this.ce = ce;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCe() {
        return ce;
    }

    public String getType() {
        Item item = this;
        return String.valueOf(item.getClass());
    }
}
