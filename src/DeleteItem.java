import java.util.ArrayList;

public class DeleteItem implements CommandUtil{
    @Override
    public void command(ArrayList message){
        String id = message.get(0).toString();
        Adventurer adventurer = MainClass.adventurers.get(id);
        String itemId = message.get(1).toString();
        if (adventurer != null) {
            adventurer.deleteItem(itemId);
        }
    }
}
