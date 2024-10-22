import java.util.ArrayList;

public class GoIntoAdventureGame implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String id = message.get(0);
        String[] newArgs = new String[]{id};
        AdventureGame.main(newArgs);
    }
}
