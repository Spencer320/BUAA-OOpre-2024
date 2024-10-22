import java.util.ArrayList;

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

    public CommandUtil selectCommand(String type) {
        int t = Integer.parseInt(type) - 1;
        return commands.get(t);
    }
}
