public class Equipment {
    private final int id;
    private final String name;
    private int durability;

    public int getEqu_id() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public Equipment(int id, String name, int durability) {
        this.id = id;
        this.name = name;
        this.durability = durability;
    }

    public void increaseDurability() {
        this.durability = this.durability + 1;
    }

}
