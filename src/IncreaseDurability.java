import java.util.ArrayList;

public class IncreaseDurability implements CommandUtil {
    @Override
    public void message(ArrayList message) {
        String id = message.get(0).toString();
        String equipmentId = message.get(1).toString();
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            adventurer.increaseDurability(equipmentId);
        }
    }
}
