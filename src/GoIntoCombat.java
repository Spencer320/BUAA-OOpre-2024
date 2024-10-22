import java.util.ArrayList;
import java.util.List;

public class GoIntoCombat implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        String name = message.get(1);
        String type = message.get(2);
        int k = Integer.parseInt(message.get(3));
        Adventurer adventurer = MainClass.adventurers.get(id);
        List<Adventurer> rivals = new ArrayList<>();
        Equipment equipment = adventurer.getCarriedEquipments().get(name);
        for (int i = 0; i < k; i++) {
            String rivalId = message.get(i + 4);
            Adventurer rival = MainClass.adventurers.get(rivalId);
            rivals.add(rival);
        }
        BattleField battleField = BattleField.getInstance();
        battleField.createCombat(adventurer,rivals,equipment,type);
        battleField.battle();
    }
}
