public class Bottle extends Item{

    protected int capacity;
    private final String type;

    public int getCapacity() {
        return capacity;
    }

    public Bottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE);
        this.capacity = capacity;
        this.type = type;
    }

    public int useBottle(){
        return 0;
    }

    @Override
    public String getType() {
        return type;
    }
}

class HPBottle extends Bottle {
    public HPBottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE, capacity, type);
    }

    @Override
    public int useBottle() {
        int value = capacity;
        capacity =0;
        return value;
    }
}

class AtkBottle extends Bottle{
    public AtkBottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE, capacity, type);
    }

    @Override
    public int useBottle() {
        int value = capacity/100 +CE;
        capacity = 0;
        return value;
    }
}

class DefBottle extends Bottle{
    public DefBottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE, capacity, type);
    }

    @Override
    public int useBottle() {
        int value = capacity/100 + CE;
        capacity = 0;
        return value;
    }
}