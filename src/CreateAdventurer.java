import java.util.ArrayList;

public class CreateAdventurer implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        String name = message.get(1);
        Adventurer adventurer = new Adventurer(id, name);
        MainClass.adventurers.put(id,adventurer);
    }
}
