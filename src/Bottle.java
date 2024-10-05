public class Bottle extends Item {
    private int capacity;
    private boolean isUsed;

    public int getCapacity() {
        return capacity;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public Bottle(String id, String name, int ce, int capacity) {
        super(id, name, ce);
        this.capacity = capacity;
        this.isUsed = false;
    }

    public int useBottle() {
        isUsed = true;
        return 0;
    }

    /*@Override
    public Class<? extends Item> getType() {
        return type;
    }*/

}




