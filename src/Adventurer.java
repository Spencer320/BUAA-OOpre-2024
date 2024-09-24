import java.util.HashMap;
import java.util.Scanner;

public class Adventurer {
    private final Scanner scanner = new Scanner(System.in);
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

    public void addBottle() {
        int bottleId = scanner.nextInt();
        String name = scanner.next();
        int capacity = scanner.nextInt();
        String type = scanner.next();
        int CE = scanner.nextInt();
        Item bottle = new Bottle(bottleId, name, CE,capacity, type );
        items.put(bottleId,bottle);
    }

    public void addEquipment() {
        int equipmentId = scanner.nextInt();
        String name = scanner.next();
        int durability = scanner.nextInt();
        int CE = scanner.nextInt();
        Item equipment = new Equipment(equipmentId, name, durability, CE);
        items.put(equipmentId,equipment);
    }

    public void increaseDurability() {
        int equipmentId = scanner.nextInt();
        Equipment equipment = (Equipment) items.get(equipmentId);
        equipment.increaseDurability();
        System.out.println(equipment.getName() + " " + equipment.getDurability());
    }

    public void deleteItem() {
        int itemId = scanner.nextInt();
        if(items.containsKey(itemId)){
            Item item = items.get(itemId);
            if (item instanceof Bottle){
                int capacity = ((Bottle) item).getCapacity();
                System.out.println(item.getType()+" "+item.getId()+capacity);
            } else if (item instanceof Equipment) {
                int durability = ((Equipment) item).getDurability();
                System.out.println(item.getType()+" "+item.getId()+durability);
            }
            items.remove(itemId);
        }
    }

    public void carryItem() {
        int itemId = scanner.nextInt();
        Item item = items.get(itemId);
        item.isCarry = true;
    }

    public void useBottle() {
        int bottleId = scanner.nextInt();
        Bottle bottle = (Bottle) items.get(bottleId);

        if (!bottle.isCarry){
            System.out.println(this.id + " fail to use " + bottle.getId());
        } else if (bottle.getCapacity() == 0) {
            items.remove(bottleId,bottle);
            System.out.println(this.id + this.HP +this.Atk+this.Def);
        } else {
            int value=bottle.useBottle();//value equals to expected increment
            if (bottle instanceof HPBottle){
                HP += value;
            } else if (bottle instanceof AtkBottle) {
                Atk += value;
            } else if (bottle instanceof DefBottle){
                Def += value;
            }
            System.out.println(this.id + this.HP +this.Atk+this.Def);
        }


    }
}