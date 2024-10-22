import java.util.ArrayList;

public class IncreaseDurability implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        ItemStore itemStore = ItemStore.getInstance();
        String id = message.get(0);
        String equipmentId = message.get(1);
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            itemStore.increaseDurability((Equipment) adventurer.getItems().get(equipmentId));
        }
    }
}
