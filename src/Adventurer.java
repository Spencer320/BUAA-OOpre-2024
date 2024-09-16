import java.util.ArrayList;

public class Adventurer {
    private final int id;
    private final String name;
    private final ArrayList<Bottle> bottleArrayList;
    private final ArrayList<Equipment> equipmentArrayList;

    public int getId() {
        return id;
    }

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bottleArrayList = new ArrayList<>();
        this.equipmentArrayList = new ArrayList<>();
    }

    public void addBottle(int id, String name, int capacity) {
        Bottle bottle = new Bottle(id, name, capacity);
        bottleArrayList.add(bottle);
    }

    public void addEquipment(int id, String name, int durability) {
        Equipment equipment = new Equipment(id, name, durability);
        equipmentArrayList.add(equipment);
    }

    public void increaseDurability(int id) {
        for (Equipment equipment : equipmentArrayList) {
            if (equipment.getEqu_id() == id) {
                equipment.increaseDurability();
                System.out.println(equipment.getName() + " " + equipment.getDurability());
            }
        }
    }

    public void deleteBottle(int id) {
        int num = 0;
        for (int i = 0; i < bottleArrayList.size(); i++) {
            if (bottleArrayList.get(i).getBot_id() == id) {
                num = i;
            }
        }
        System.out.println(bottleArrayList.size() - 1 + " "
                + bottleArrayList.get(num).getName() + " "
                + bottleArrayList.get(num).getCapacity());
        bottleArrayList.remove(num);
    }

    public void deleteEquipment(int id) {
        int num = 0;
        for (int i = 0; i < equipmentArrayList.size(); i++) {
            if (equipmentArrayList.get(i).getEqu_id() == id) {
                num = i;
            }
        }
        System.out.println(equipmentArrayList.size() - 1 + " "
                + equipmentArrayList.get(num).getName() + " "
                + equipmentArrayList.get(num).getDurability());
        equipmentArrayList.remove(num);
    }
}