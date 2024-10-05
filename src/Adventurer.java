import java.util.HashMap;

public class Adventurer {
    private final String id;
    private final String name;
    private HashMap<String, Item> items;

    private int atk;
    private int def;
    private int hp;
    private int ce;

    public Adventurer(String id, String name) {
        this.id = id;
        this.name = name;
        this.items = new HashMap<String, Item>();
        this.atk = 1;
        this.def = 0;
        this.hp = 500;
        this.ce = atk + def;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void addBottle(String bottleId, String name, int ce, int capacity, String type) {
        Item bottle = null;
        switch (type) {
            case "HpBottle":
                bottle = new HpBottle(bottleId, name, ce, capacity);
                break;
            case "AtkBottle":
                bottle = new AtkBottle(bottleId, name, ce, capacity);
                break;
            case "DefBottle":
                bottle = new DefBottle(bottleId, name, ce, capacity);
                break;
            default:
        }
        items.put(bottleId, bottle);
    }

    public void addEquipment(String equipmentId, String name, int durability, int ce) {
        Item equipment = new Equipment(equipmentId, name, durability, ce);
        items.put(equipmentId, equipment);
    }

    public void increaseDurability(String equipmentId) {
        Equipment equipment = (Equipment) items.get(equipmentId);
        equipment.increaseDurability();
        System.out.println(equipment.getName() + " " + equipment.getDurability());
    }

    public void deleteItem(String itemId) {
        if (items.containsKey(itemId)) {
            Item item = items.get(itemId);
            if (item instanceof Bottle) {
                int capacity = ((Bottle) item).getCapacity();
                System.out.println(item.getType() + " " + item.getName() + " " + capacity);
            } else if (item instanceof Equipment) {
                int durability = ((Equipment) item).getDurability();
                System.out.println(item.getType() + " " + item.getName() + " " + durability);
            }
            items.remove(itemId);
        }
    }

    public void carryItem(String itemId) {
        Item item = items.get(itemId);
        item.setCarried(true);
    }

    public void useBottle(String bottleId) {
        Bottle bottle = (Bottle) items.get(bottleId);

        if (! bottle.isCarried()) {
            System.out.println(this.name + " fail to use " + bottle.getName());
        } else if (bottle.isUsed()) {
            items.remove(bottleId, bottle);
            System.out.println(this.name + " " + this.hp + " " + this.atk + " " + this.def);
        } else {
            if (bottle instanceof HpBottle) {
                HpBottle hpBottle = (HpBottle) bottle;
                hp += hpBottle.useBottle();
            } else if (bottle instanceof AtkBottle) {
                AtkBottle atkBottle = (AtkBottle) bottle;
                atk += atkBottle.useBottle();
            } else if (bottle instanceof DefBottle) {
                DefBottle defBottle = (DefBottle) bottle;
                def += defBottle.useBottle();
            }
            System.out.println(this.name + " " + this.hp + " " + this.atk + " " + this.def);
        }


    }
}