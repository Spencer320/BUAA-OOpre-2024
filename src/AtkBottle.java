public class AtkBottle extends Bottle {
    private int atk;

    public AtkBottle(String id, String name, int ce, int capacity, String type) {
        super(id, name, ce, capacity, type);
        this.atk = capacity / 100 + ce;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return atk;
    }
}
