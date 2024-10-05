import java.util.ArrayList;

public class Manager {
    private final ArrayList<CommandUtil> commands = new ArrayList<>();

    public Manager() {
        commands.add(new CreateAdventurer());
        commands.add(new AddBottle());
        commands.add(new AddEquipment());
        commands.add(new IncreaseDurability());
        commands.add(new DeleteItem());
        commands.add(new CarryItem());
        commands.add(new UseBottle());
    }

    public CommandUtil selectCommand(String type){
        int t = Integer.parseInt(type) - 1;
        return commands.get(t);
    }
}
