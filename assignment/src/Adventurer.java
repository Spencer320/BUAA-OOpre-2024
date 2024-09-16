import java.util.ArrayList;

public class Adventurer {
    private int adv_id;
    private String name;
    private ArrayList<Bottle> bottleArrayList;
    private ArrayList<Equipment> equipmentArrayList;

    public int getAdv_id() {
        return adv_id;
    }

    public Adventurer(int adv_id, String name) {
        this.adv_id = adv_id;
        this.name = name;
        this.bottleArrayList = new ArrayList<>();
        this.equipmentArrayList = new ArrayList<>();
    }

    public void addBottle(int bot_id, String name, int capacity) {
        Bottle bottle = new Bottle(bot_id, name, capacity);
        bottleArrayList.add(bottle);
    }

    public void addEquipment(int equ_id, String name, int durability) {
        Equipment equipment = new Equipment(equ_id, name, durability);
        equipmentArrayList.add(equipment);
    }

    public void increaseDurability(int equ_id) {
        for (Equipment equipment : equipmentArrayList) {
            if (equipment.getEqu_id() == equ_id) {
                equipment.increaseDurability();
                System.out.println(equipment.getName() + " " + equipment.getDurability());
            }
        }
    }

    public void deleteBottle(int bot_id) {
        int num = 0;
        for (int i = 0; i < bottleArrayList.size(); i++) {
            if(bottleArrayList.get(i).getBot_id() == bot_id){
                num = i;
            }
        }
        System.out.println(bottleArrayList.size()-1 + " " + bottleArrayList.get(num).getName() + " " +bottleArrayList.get(num).getCapacity());
        bottleArrayList.remove(num);
    }

    public void deleteEquipment(int equ_id){
        int num = 0;
        for (int i = 0; i < equipmentArrayList.size(); i++) {
            if(equipmentArrayList.get(i).getEqu_id() == equ_id){
                num = i;
            }
        }
        System.out.println(equipmentArrayList.size()-1 + " " + equipmentArrayList.get(num).getName() + " " +equipmentArrayList.get(num).getDurability());
        equipmentArrayList.remove(num);
    }
}