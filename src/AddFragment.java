import java.util.ArrayList;

public class AddFragment implements CommandUtil {

    @Override
    public void message(ArrayList message) {
        String id = message.get(0).toString();
        String fragmentId = message.get(1).toString();
        String name = message.get(2).toString();
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            adventurer.addFragment(fragmentId, name);
        }
    }
}
