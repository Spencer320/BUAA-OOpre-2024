import java.util.ArrayList;

public class CreateAdventurer implements CommandUtil{
    @Override
    public void command(ArrayList message){
        String id = message.get(0).toString();
        String name = message.get(1).toString();
        Adventurer adventurer = new Adventurer(id, name);
        MainClass.adventurers.put(id,adventurer);
    }
}
