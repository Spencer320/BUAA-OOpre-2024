public class Bottle extends Item{
    protected int capacity;
    private final String type;
    private boolean isUsed;

    public boolean isUsed() {
        return isUsed;
    }

    public Bottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE);
        this.capacity = capacity;
        this.type = type;
        this.isUsed = false;
    }

    public int useBottle(){
        isUsed = true;
        return 0;
    }

    @Override
    public String getType() {
        return type;
    }
}

class HpBottle extends Bottle {
    int Hp;
    public HpBottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE, capacity, type);
        this.Hp = capacity;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return Hp;
    }
}

class AtkBottle extends Bottle{
    int Atk;
    public AtkBottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE, capacity, type);
        this.Atk = capacity/100 +CE;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return Atk;
    }
}

class DefBottle extends Bottle{
    int Def;
    public DefBottle(int id, String name, int CE, int capacity, String type) {
        super(id, name, CE, capacity, type);
        Def = capacity/100 + CE;
    }

    @Override
    public int useBottle() {
        super.useBottle();
        return Def;
    }
}