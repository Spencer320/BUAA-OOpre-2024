import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adventurer {
    //basic attributes
    private final String id;
    private final String name;
    private final HashMap<String, Item> items;
    private final HashMap<String, List<Fragment>> fragments;

    private int atk;
    private int def;
    private int hp;
    private int ce;
    //pack
    private final HashMap<String,Equipment> carriedEquipments;
    private final HashMap<String, HashMap<String,Bottle>> carriedBottles;
    //employ
    private final ArrayList<Mercenary> mercenaries;

    public Adventurer(String id, String name) {
        this.id = id;
        this.name = name;
        this.items = new HashMap<>();
        this.fragments = new HashMap<>();
        this.atk = 1;
        this.def = 0;
        this.hp = 500;
        this.ce = atk + def;
        this.carriedEquipments = new HashMap<>();
        this.carriedBottles = new HashMap<>();
        mercenaries = new ArrayList<>();
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

    public int getCe() {
        return ce;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public HashMap<String, Equipment> getCarriedEquipments() {
        return carriedEquipments;
    }

    public HashMap<String, HashMap<String, Bottle>> getCarriedBottles() {
        return carriedBottles;
    }

    public ArrayList<Mercenary> getMercenaries() {
        return mercenaries;
    }

    public void updateCe() {
        this.ce = this.atk + this.def;
    }

    public void updateAtk(int atk) {
        this.atk = atk;
    }

    public void updateDef(int def) {
        this.def = def;
    }

    public void updateHp(int hp) {
        this.hp = hp;
    }

    public void addBottle(Item bottle) {
        items.put(bottle.getId(), bottle);
    }

    public void addEquipment(Item equipment) {
        items.put(equipment.getId(), equipment);
    }

    public void deleteItem(String itemId) {
        if (items.containsKey(itemId)) {
            Item item = items.get(itemId);
            if (item instanceof Bottle) {
                int capacity = ((Bottle) item).getCapacity();
                String name = item.getName();
                deleteBottle((Bottle) item);
                System.out.println(item.getType() + " " + name + " " + capacity);
            } else if (item instanceof Equipment) {
                int durability = ((Equipment) item).getDurability();
                String name = item.getName();
                deleteEquipment((Equipment) item);
                System.out.println(item.getType() + " " + name + " " + durability);
            }
        }
    }

    public void deleteBottle(Bottle bottle) {
        String name = bottle.getName();
        String id = bottle.getId();
        if (carriedBottles.containsKey(name)) {
            HashMap<String,Bottle> bottles = carriedBottles.get(name);
            if (bottles.containsKey(id)) {
                bottles.remove(id,bottle);
            }
        }
        items.remove(id);
    }

    public void deleteEquipment(Equipment equipment) {
        String name = equipment.getName();
        String id = equipment.getId();
        if (carriedEquipments.containsKey(name)) {
            carriedEquipments.remove(name,equipment);
        }
        items.remove(id);
    }

    public void carryItem(String itemId) {
        Item item = items.get(itemId);
        if (item instanceof Bottle) {
            Bottle bottle = (Bottle) item;
            carryBottle(bottle);
        } else if (item instanceof Equipment) {
            Equipment equipment = (Equipment) item;
            carriedEquipments.put(equipment.getName(),equipment);
        }
    }

    public void carryBottle(Bottle bottle) {
        int maxCount = ce / 5 + 1;
        String name = bottle.getName();
        carriedBottles.putIfAbsent(name,new HashMap<>());
        HashMap<String, Bottle> bottles = carriedBottles.get(name);
        if (bottles.size() < maxCount) {
            bottles.put(bottle.getId(),bottle);
        }
    }

    public void useBottle(String bottleId) {
        Bottle bottle = (Bottle) items.get(bottleId);
        HashMap<String,Bottle> bottles = carriedBottles.get(bottle.getName());
        if (bottles == null || !bottles.containsKey(bottleId)) {
            System.out.println(this.name + " fail to use " + bottle.getName());
        } else if (bottle.isUsed()) {
            deleteBottle(bottle);
            System.out.println(this.name + " " + this.hp + " " + this.atk + " " + this.def);
        } else {
            if (bottle instanceof HpBottle) {
                HpBottle hpBottle = (HpBottle) bottle;
                hp += hpBottle.useBottle();
            } else if (bottle instanceof AtkBottle) {
                AtkBottle atkBottle = (AtkBottle) bottle;
                atk += atkBottle.useBottle();
                updateCe();
            } else if (bottle instanceof DefBottle) {
                DefBottle defBottle = (DefBottle) bottle;
                def += defBottle.useBottle();
                updateCe();
            }
            System.out.println(this.name + " " + this.hp + " " + this.atk + " " + this.def);
        }
    }

    public void addFragment(String fragmentId, String name) {
        Fragment fragment = new Fragment(fragmentId,name);
        fragments.putIfAbsent(name,new ArrayList<>());
        List<Fragment> partFragments = fragments.get(name);
        partFragments.add(fragment);
    }

    public void useFragment(String welfareId, String name) {
        List<Fragment> partFragments = fragments.get(name);
        int count = partFragments.size();
        int changeCount = 5;
        if (count < changeCount) {
            System.out.println(count + ": Not enough fragments collected yet");
        } else {
            for (int i = 0; i < changeCount; i++) {
                if (!partFragments.isEmpty()) {
                    partFragments.remove(0);
                }
            }
            if (items.containsKey(welfareId)) {
                if (items.get(welfareId) instanceof Bottle) {
                    Bottle bottle = (Bottle) items.get(welfareId);
                    if (bottle.isUsed()) {
                        bottle.resetUsed();
                    }
                    System.out.println(bottle.getName() + " " + bottle.getCapacity());
                } else if (items.get(welfareId) instanceof Equipment) {
                    Equipment equipment = (Equipment) items.get(welfareId);
                    equipment.increaseDurability();
                    System.out.println(equipment.getName() + " " + equipment.getDurability());
                }
            } else {
                ItemStore itemStore = ItemStore.getInstance();
                addBottle(itemStore.createBottle(welfareId,name,0,100,"HpBottle"));
                System.out.println("Congratulations! HpBottle " + name + " acquired");
            }
        }
    }

    public void employAdventurer(Adventurer adventurer) {
        Mercenary mercenary = new Mercenary(adventurer,0);
        mercenaries.add(mercenary);
    }

    public int getComprehensiveCE() {
        int ce = this.ce;
        for (HashMap<String, Bottle> bottles : getCarriedBottles().values()) {
            for (Bottle bottle : bottles.values()) {
                ce += bottle.getCe();
            }
        }
        for (Equipment equipment : getCarriedEquipments().values()) {
            ce += equipment.getCe();
        }
        for (Mercenary mercenary : getMercenaries()) {
            ce += mercenary.getAdventurer().getCe();
        }
        return ce;
    }
}