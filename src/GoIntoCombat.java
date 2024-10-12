import java.util.ArrayList;
import java.util.List;

public class GoIntoCombat implements CommandUtil {
    @Override
    public void command(ArrayList message) {
        String id = message.get(0).toString();
        String name = message.get(1).toString();
        int k = Integer.parseInt(message.get(2).toString());
        Adventurer adventurer = MainClass.adventurers.get(id);
        List<Adventurer> rivals = new ArrayList<>();
        Equipment equipment = adventurer.getCarriedEquipments().get(name);
        for (int i = 0; i < k; i++) {
            String rivalId = message.get(i + 3).toString();
            Adventurer rival = MainClass.adventurers.get(rivalId);
            rivals.add(rival);
        }
        Combat combat = new Combat(adventurer,rivals,equipment);
        boolean isCombat = combat.isCombat();
        if (isCombat) {
            combat.success();
        } else {
            combat.failure();
        }
    }
}
