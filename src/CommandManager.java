import java.util.ArrayList;

public class CommandManager {
    private final ArrayList<CommandUtil> commands = new ArrayList<>();

    public CommandManager() {
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
    }

    public CommandUtil selectCommand(String type) {
        int t = Integer.parseInt(type) - 1;
        return commands.get(t);
    }
}
