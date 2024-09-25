import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    private static ArrayList<Adventurer> adventurerArrayList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int line = scanner.nextInt();
        for (int i = 0; i < line; i++) {
            String command = scanner.next();
            if ("1".equals(command)) {
                createAdventurer();
            } else if ("2".equals(command)) {
                Adventurer adventurer = getAdventurer();
                int bottleId = scanner.nextInt();
                String name = scanner.next();
                int capacity = scanner.nextInt();
                String type = scanner.next();
                int ce = scanner.nextInt();
                adventurer.addBottle(bottleId, name, ce, capacity, type);
            } else if ("3".equals(command)) {
                Adventurer adventurer = getAdventurer();
                int equipmentId = scanner.nextInt();
                String name = scanner.next();
                int durability = scanner.nextInt();
                int ce = scanner.nextInt();
                adventurer.addEquipment(equipmentId, name, durability, ce);
            } else if ("4".equals(command)) {
                Adventurer adventurer = getAdventurer();
                int equipmentId = scanner.nextInt();
                adventurer.increaseDurability(equipmentId);
            } else if ("5".equals(command)) {
                Adventurer adventurer = getAdventurer();
                int itemId = scanner.nextInt();
                adventurer.deleteItem(itemId);
            } else if ("6".equals(command)) {
                Adventurer adventurer = getAdventurer();
                int itemId = scanner.nextInt();
                adventurer.carryItem(itemId);
            } else if ("7".equals(command)) {
                Adventurer adventurer = getAdventurer();
                int bottleId = scanner.nextInt();
                adventurer.useBottle(bottleId);
            }
        }
    }

    static void createAdventurer() {
        int adventurerId = scanner.nextInt();
        String name = scanner.next();
        Adventurer adventurer = new Adventurer(adventurerId, name);
        adventurerArrayList.add(adventurer);
    }

    static Adventurer getAdventurer() {
        int adventurerId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                return adventurer;
            }
        }
        return null;
    }
}


