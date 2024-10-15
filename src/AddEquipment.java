import java.util.ArrayList;

public class AddEquipment implements CommandUtil {
    @Override
    public void message(ArrayList message) {
        String id = message.get(0).toString();
        String equipmentId = message.get(1).toString();
        String name = message.get(2).toString();
        int durability = Integer.parseInt(message.get(3).toString());
        String type = message.get(4).toString();
        int ce = Integer.parseInt(message.get(5).toString());
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            adventurer.addEquipment(equipmentId, name, durability, ce, type);
        }
    }
}
