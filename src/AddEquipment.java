import java.util.ArrayList;

public class AddEquipment implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        String equipmentId = message.get(1);
        String name = message.get(2);
        int durability = Integer.parseInt(message.get(3));
        String type = message.get(4);
        int ce = Integer.parseInt(message.get(5));
        ItemStore itemStore = ItemStore.getInstance();
        Adventurer adventurer = MainClass.adventurers.get(id);
        Item equipment = itemStore.createEquipment(equipmentId,name,durability,ce,type);
        if (adventurer != null) {
            adventurer.addEquipment(equipment);
        }
    }
}
