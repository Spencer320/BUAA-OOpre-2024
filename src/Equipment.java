public class Equipment extends Item {
    private int durability;

    public int getDurability() {
        return durability;
    }

    public Equipment(String id, String name, int ce, int durability) {
        super(id, name, ce);
        this.durability = durability;
    }

    public void increaseDurability() {
        this.durability = this.durability + 1;
    }

    public void decreaseDurability() { this.durability = this.durability - 1; }

    public int newHp(int atk,int def,int hp) {
        return hp + def - atk - this.getCe();
    }
}
