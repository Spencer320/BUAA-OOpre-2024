import java.util.ArrayList;

public class UseBottle implements CommandUtil {
    @Override
    public void message(ArrayList message) {
        String id = message.get(0).toString();
        Adventurer adventurer = MainClass.adventurers.get(id);
        String itemId = message.get(1).toString();
        if (adventurer != null) {
            adventurer.useBottle(itemId);
        }
    }
}
