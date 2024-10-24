public class AtkBottle extends Bottle {
    private final int atk;

    public AtkBottle(String id, String name, int ce, int capacity) {
        super(id, name, ce, capacity);
        this.atk = capacity / 100 + ce;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return atk;
    }
}
