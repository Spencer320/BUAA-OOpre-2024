import java.util.ArrayList;

public class UseFragment implements CommandUtil {
    @Override
    public void message(ArrayList message) {
        String id = message.get(0).toString();
        String name = message.get(1).toString();
        String welfareId = message.get(2).toString();
        Adventurer adventurer = MainClass.adventurers.get(id);
        if (adventurer != null) {
            adventurer.useFragment(welfareId, name);
        }
    }
}
