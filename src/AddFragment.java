import java.util.ArrayList;

public class AddFragment implements CommandUtil {

    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        String fragmentId = message.get(1);
        String name = message.get(2);
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            adventurer.addFragment(fragmentId, name);
        }
    }
}
