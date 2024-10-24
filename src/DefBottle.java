public class DefBottle extends Bottle {
    private final int def;

    public DefBottle(String id, String name, int ce, int capacity) {
        super(id, name, ce, capacity);
        def = capacity / 100 + ce;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return def;
    }

}