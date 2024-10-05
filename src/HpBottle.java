public class HpBottle extends Bottle {
    private int hp;

    public HpBottle(String id, String name, int ce, int capacity, String type) {
        super(id, name, ce, capacity, type);
        this.hp = capacity;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return hp;
    }
}
