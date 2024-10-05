public class DefBottle extends Bottle {
    private int def;

    public DefBottle(String id, String name, int ce, int capacity, String type) {
        super(id, name, ce, capacity, type);
        def = capacity / 100 + ce;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return def;
    }
}