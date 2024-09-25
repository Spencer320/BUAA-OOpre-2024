import java.util.HashMap;
import java.util.Scanner;

public class MainClass {
    private static final HashMap<Integer,Adventurer> adventurers = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int line = scanner.nextInt();
        for (int i = 0; i < line; i++) {
            String command = scanner.next();
            int adventurerId = scanner.nextInt();
            if ("1".equals(command)) {
                String name = scanner.next();
                Adventurer adventurer = new Adventurer(adventurerId, name);
                adventurers.put(adventurerId,adventurer);
            } else if ("2".equals(command)) {
                Adventurer adventurer = adventurers.get(adventurerId);
                int bottleId = scanner.nextInt();
                String name = scanner.next();
                int capacity = scanner.nextInt();
                String type = scanner.next();
                int ce = scanner.nextInt();
                if (adventurer != null) {
                    adventurer.addBottle(bottleId, name, ce, capacity, type);
                }
            } else if ("3".equals(command)) {
                Adventurer adventurer = adventurers.get(adventurerId);
                int equipmentId = scanner.nextInt();
                String name = scanner.next();
                int durability = scanner.nextInt();
                int ce = scanner.nextInt();
                if (adventurer != null) {
                    adventurer.addEquipment(equipmentId, name, durability, ce);
                }
            } else if ("4".equals(command)) {
                Adventurer adventurer = adventurers.get(adventurerId);
                int equipmentId = scanner.nextInt();
                if (adventurer != null) {
                    adventurer.increaseDurability(equipmentId);
                }
            } else if ("5".equals(command)) {
                Adventurer adventurer = adventurers.get(adventurerId);
                int itemId = scanner.nextInt();
                if (adventurer != null) {
                    adventurer.deleteItem(itemId);
                }
            } else if ("6".equals(command)) {
                Adventurer adventurer = adventurers.get(adventurerId);
                int itemId = scanner.nextInt();
                if (adventurer != null) {
                    adventurer.carryItem(itemId);
                }
            } else if ("7".equals(command)) {
                Adventurer adventurer = adventurers.get(adventurerId);
                int bottleId = scanner.nextInt();
                if (adventurer != null) {
                    adventurer.useBottle(bottleId);
                }
            }
        }
    }
}


