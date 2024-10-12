public class HpBottle extends Bottle {
    private int hp;

    public HpBottle(String id, String name, int ce, int capacity) {
        super(id, name, ce, capacity);
        this.hp = capacity;
    }

    @Override
    public int getCe() {
        return hp;
    }

}
