public class ItemStore {
    private static final ItemStore itemStore = new ItemStore();

    public static ItemStore getInstance() {
        return itemStore;
    }

    public Item createBottle(String bottleId, String name, int ce, int capacity, String type) {
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
        return bottle;
    }

    public Item createEquipment(String equipmentId, String name, int durability, int ce,String type) {
        Item equipment = null;
        switch (type) {
            case "Axe":
                equipment = new Axe(equipmentId,name,ce,durability);
                break;
            case "Sword":
                equipment = new Sword(equipmentId,name,ce,durability);
                break;
            case "Blade":
                equipment = new Blade(equipmentId,name,ce,durability);
                break;
            default:
        }
        return equipment;
    }

    public void increaseDurability(Equipment equipment) {
        equipment.increaseDurability();
        System.out.println(equipment.getName() + " " + equipment.getDurability());
    }
}
