import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private static CommandManager commandManager;
    private final ArrayList<CommandUtil> commands = new ArrayList<>();

    private CommandManager() {
        commands.add(new CreateAdventurer());
        commands.add(new AddBottle());
        commands.add(new AddEquipment());
        commands.add(new IncreaseDurability());
        commands.add(new DeleteItem());
        commands.add(new CarryItem());
        commands.add(new UseBottle());
        commands.add(new AddFragment());
        commands.add(new UseFragment());
        commands.add(new GoIntoCombat());
        commands.add(new EmployAdventurer());
        commands.add(new GoIntoAdventureGame());
    }

    public static CommandManager getInstance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
    }

    CommandUtil selectCommand(String type) {
        int t = Integer.parseInt(type) - 1;
        return commands.get(t);
    }

    interface CommandUtil {
        void execute(ArrayList<String> message);
    }

    static class CreateAdventurer implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            String id = message.get(0);
            String name = message.get(1);
            Adventurer adventurer = new Adventurer(id, name);
            MainClass.adventurers.put(id, adventurer);
        }
    }

    static class AddBottle implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            String id = message.get(0);
            String bottleId = message.get(1);
            String name = message.get(2);
            int capacity = Integer.parseInt(message.get(3));
            String type = message.get(4);
            int ce = Integer.parseInt(message.get(5));
            ItemStore itemStore = ItemStore.getInstance();
            Adventurer adventurer = MainClass.adventurers.get(id);
            Item bottle = itemStore.createBottle(bottleId, name, ce, capacity, type);
            if (adventurer != null) {
                adventurer.addBottle(bottle);
            }
        }
    }

    static class AddEquipment implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            String id = message.get(0);
            String equipmentId = message.get(1);
            String name = message.get(2);
            int durability = Integer.parseInt(message.get(3));
            String type = message.get(4);
            int ce = Integer.parseInt(message.get(5));
            ItemStore itemStore = ItemStore.getInstance();
            Adventurer adventurer = MainClass.adventurers.get(id);
            Item equipment = itemStore.createEquipment(equipmentId, name, durability, ce, type);
            if (adventurer != null) {
                adventurer.addEquipment(equipment);
            }
        }
    }

    static class IncreaseDurability implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            ItemStore itemStore = ItemStore.getInstance();
            String id = message.get(0);
            String equipmentId = message.get(1);
            Adventurer adventurer = MainClass.adventurers.get(id);
            if (adventurer != null) {
                itemStore.increaseDurability((Equipment) adventurer.getItems().get(equipmentId));
            }
        }
    }

    static class DeleteItem implements CommandUtil {
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

    static class CarryItem implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            String id = message.get(0);
            Adventurer adventurer = MainClass.adventurers.get(id);
            String itemId = message.get(1);
            if (adventurer != null) {
                adventurer.carryItem(itemId);
            }
        }
    }

    static class UseBottle implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            String id = message.get(0);
            Adventurer adventurer = MainClass.adventurers.get(id);
            String itemId = message.get(1);
            if (adventurer != null) {
                adventurer.useBottle(itemId);
            }
        }
    }

    static class AddFragment implements CommandUtil {

        public AddFragment() {
        }

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

    static class UseFragment implements CommandUtil {
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

    static class GoIntoCombat implements CommandUtil {
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
            Combat combat = null;
            switch (type) {
                case "normal":
                    combat = new NormalCombat(adventurer,rivals,equipment);
                    break;
                case "chain":
                    combat = new ChainCombat(adventurer,rivals,equipment);
                    break;
                default:
            }
            if (combat != null) {
                boolean isCombat = combat.isCombat();
                if (isCombat) {
                    combat.success();
                } else {
                    combat.failure();
                }
            }

        }
    }

    static class EmployAdventurer implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            String employerId = message.get(0);
            String employeeId = message.get(1);
            Adventurer employer = MainClass.adventurers.get(employerId);
            Adventurer employee = MainClass.adventurers.get(employeeId);
            employer.employAdventurer(employee);
        }
    }

    static class GoIntoAdventureGame implements CommandUtil {
        @Override
        public void execute(ArrayList<String> message) {
            String id = message.get(0);
            Adventurer adventurer = MainClass.adventurers.get(id);
            AdventureGame.dungeon(adventurer);
        }
    }
}