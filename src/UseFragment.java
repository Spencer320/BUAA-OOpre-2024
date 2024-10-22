import java.util.ArrayList;

public class UseFragment implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        String name = message.get(1);
        String welfareId = message.get(2);
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            adventurer.useFragment(welfareId, name);
        }
    }
}
