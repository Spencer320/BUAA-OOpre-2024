public class Equipment extends Item {
    private int durability;

    public int getDurability() {
        return durability;
    }

    public Equipment(String id, String name, int durability, int ce) {
        super(id, name, ce);
        this.durability = durability;
    }

    public void increaseDurability() {
        this.durability = this.durability + 1;
    }

}
