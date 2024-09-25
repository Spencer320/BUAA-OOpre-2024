public class Equipment extends Item {
    private int durability;

    public String getName() {
        return getName();
    }

    public int getDurability() {
        return durability;
    }

    public Equipment(int id, String name, int ce, int durability) {
        super(id, name, ce);
        this.durability = durability;
    }

    public void increaseDurability() {
        this.durability = this.durability + 1;
    }

}
