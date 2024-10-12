public class DefBottle extends Bottle {
    private int def;

    public DefBottle(String id, String name, int ce, int capacity) {
        super(id, name, ce, capacity);
        def = capacity / 100 + ce;
    }

    @Override
    public int getCe() {
        return def;
    }
/*@Override
    public int useBottle() {
        super.useBottle();
        return def;
    }*/
}