import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    static final ArrayList<Adventurer> adventurerArrayList = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int line = scanner.nextInt();
        int i = 0;
        while (i < line) {
            i++;
            String command = scanner.next();
            if ("1".equals(command)) {
                createAdventurer();
            } else if ("2".equals(command)) {
                addBottleForAdventurer();
            } else if ("3".equals(command)) {
                addEquipmentForAdventurer();
            } else if ("4".equals(command)) {
                increaseDurability();
            } else if ("5".equals(command)) {
                deleteBottle();
            } else if ("6".equals(command)) {
                deleteEquipment();
            }
        }
    }

    static void createAdventurer() {
        int adventurerId = scanner.nextInt();
        String name = scanner.next();
        Adventurer adventurer = new Adventurer(adventurerId, name);
        adventurerArrayList.add(adventurer);
    }

    static void addBottleForAdventurer() {
        int adventurerId = scanner.nextInt();
        int bottleId = scanner.nextInt();
        String name = scanner.next();
        int capacity = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.addBottle(bottleId, name, capacity);
            }
        }
    }

    static void addEquipmentForAdventurer() {
        int adventurerId = scanner.nextInt();
        int equipmentId = scanner.nextInt();
        String name = scanner.next();
        int durability = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.addEquipment(equipmentId, name, durability);
            }
        }
    }

    static void increaseDurability() {
        int adventurerId = scanner.nextInt();
        int equipmentId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.increaseDurability(equipmentId);
            }
        }
    }

    static void deleteBottle() {
        int adventurerId = scanner.nextInt();
        int bottleId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.deleteBottle(bottleId);
            }
        }
    }

    static void deleteEquipment() {
        int adventurerId = scanner.nextInt();
        int equipmentId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.deleteEquipment(equipmentId);
            }
        }
    }
}
