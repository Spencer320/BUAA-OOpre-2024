public class Equipment extends Item{
    private int durability;

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public Equipment(int id, String name, int CE, int durability) {
        super(id, name, CE);
        this.durability = durability;
    }

    public void increaseDurability() {
        this.durability = this.durability + 1;
    }

}
