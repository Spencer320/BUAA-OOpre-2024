import java.util.ArrayList;

public class AddBottle implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        String bottleId = message.get(1);
        String name = message.get(2);
        int capacity = Integer.parseInt(message.get(3));
        String type = message.get(4);
        int ce = Integer.parseInt(message.get(5));
        ItemStore itemStore = ItemStore.getInstance();
        Adventurer adventurer = MainClass.adventurers.get(id);
        Item bottle = itemStore.createBottle(bottleId, name, ce, capacity, type);
        if (adventurer != null) {
            adventurer.addBottle(bottle);
        }
    }
}
