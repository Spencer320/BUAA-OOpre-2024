import java.util.HashMap;

public class Adventurer {
    private final int id;
    private final String name;
    private HashMap<Integer,Item> items;

    private int Atk;
    private int Def;
    private int HP;
    private int CE;

    public int getId() {
        return id;
    }

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.items = new HashMap<>();
        this.Atk = 1;
        this.Def = 0;
        this.HP = 500;
        this.CE = Atk + Def;
    }

    public void addBottle(int id, String name, int CE,int capacity,String type) {
        Item bottle = new Bottle(id, name, CE,capacity, type );
        items.put(id,bottle);
    }

    public void addEquipment(int id, String name, int durability,int CE) {
        Item equipment = new Equipment(id, name, durability, CE);
        items.put(id,equipment);
    }

    public void increaseDurability(int id) {
        Equipment equipment = (Equipment) items.get(id);
        equipment.increaseDurability();
        System.out.println(equipment.getName() + " " + equipment.getDurability());
    }

    public void deleteItem(int id) {
        if(items.containsKey(id)){
            Item item = items.get(id);
            if (item instanceof Bottle){
                int capacity = ((Bottle) item).getCapacity();
                System.out.println(item.getType()+" "+item.getId()+capacity);
            } else if (item instanceof Equipment) {
                int durability = ((Equipment) item).getDurability();
                System.out.println(item.getType()+" "+item.getId()+durability);
            }
            items.remove(id);
        }
    }

    public void carryItem(int id) {
        Item item = items.get(id);
        item.isCarry = true;
    }

    public boolean useBottle(int id) {
        Item item = items.get(id);
        if(item instanceof Bottle){
            Bottle bottle = (Bottle) item;
            if (bottle.isCarry == false){
                return false;
            } else if (bottle.getCapacity() == 0) {
                return false;
            } else {
                int value=bottle.useBottle();//value equals to expected increment
                if (bottle instanceof HPBottle){
                    HP += value;
                } else if (bottle instanceof AtkBottle) {
                    Atk += value;
                } else if (bottle instanceof DefBottle){
                    Def += value;
                }
                return true;
            }
        }else {
            return false;
        }

    }
}