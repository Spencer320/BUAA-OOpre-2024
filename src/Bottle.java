public class Bottle extends Item {
    private int capacity;
    private final String type;
    private boolean isUsed;

    public int getCapacity() {
        return capacity;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public Bottle(String id, String name, int ce, int capacity, String type) {
        super(id, name, ce);
        this.capacity = capacity;
        this.type = type;
        this.isUsed = false;
    }

    public int useBottle() {
        isUsed = true;
        return 0;
    }

    @Override
    public String getType() {
        return type;
    }

}




