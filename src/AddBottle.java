import java.util.ArrayList;

public class AddBottle implements CommandUtil {
    @Override
    public void command(ArrayList message) {
        String id = message.get(0).toString();
        String bottleId = message.get(1).toString();
        String name = message.get(2).toString();
        int capacity = Integer.parseInt(message.get(3).toString());
        String type = message.get(4).toString();
        int ce = Integer.parseInt(message.get(5).toString());
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            adventurer.addBottle(bottleId, name, ce, capacity, type);
        }
    }
}
