import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MainClass {
    static final HashMap<String,Adventurer> adventurers = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> inputInfo = getInputInfo();
        typeCommand(inputInfo);
    }

    public static ArrayList<ArrayList<String>> getInputInfo() {
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine();
            String[] strings = nextLine.trim().split(" +");
            inputInfo.add(new ArrayList<>(Arrays.asList(strings)));
        }
        return inputInfo;
    }

    public static void typeCommand(ArrayList<ArrayList<String>> inputInfo) {
        CommandManager manager = CommandManager.getInstance();
        for (ArrayList<String> cmd : inputInfo) {
            ArrayList<String> message = new ArrayList<>();
            String type = cmd.get(0);
            for (int j = 1; j < cmd.size(); j++) {
                message.add(cmd.get(j));
            }
            CommandManager.CommandUtil command = manager.selectCommand(type);
            command.execute(message);
        }
    }
}


