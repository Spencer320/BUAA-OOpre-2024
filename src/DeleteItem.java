import java.util.ArrayList;

public class DeleteItem implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        Adventurer adventurer = MainClass.adventurers.get(id);
        String itemId = message.get(1);
        if (adventurer != null) {
            adventurer.deleteItem(itemId);
        }
    }
}
