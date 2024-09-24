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
                addBottle();
            } else if ("3".equals(command)) {
                addEquipment();
            } else if ("4".equals(command)) {
                increaseDurability();
            } else if ("5".equals(command)) {
                deleteItem();
            } else if ("6".equals(command)) {
                carryItem();
            } else if ("7".equals(command)) {
                useBottle();
            }
        }
    }

    static void createAdventurer() {
        int adventurerId = scanner.nextInt();
        String name = scanner.next();
        Adventurer adventurer = new Adventurer(adventurerId, name);
        adventurerArrayList.add(adventurer);
    }

    static void addBottle() {
        int adventurerId = scanner.nextInt();
        int bottleId = scanner.nextInt();
        String name = scanner.next();
        int capacity = scanner.nextInt();
        String type = scanner.next();
        int CE = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.addBottle(bottleId, name, CE, capacity, type);
            }
        }
    }

    static void addEquipment() {
        int adventurerId = scanner.nextInt();
        int equipmentId = scanner.nextInt();
        String name = scanner.next();
        int durability = scanner.nextInt();
        int CE = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.addEquipment(equipmentId, name, durability, CE);
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

    static void deleteItem() {
        int adventurerId = scanner.nextInt();
        int itemId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.deleteItem(itemId);
            }
        }
    }

    static void carryItem(){
        int adventurerId = scanner.nextInt();
        int itemId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                adventurer.carryItem(itemId);
            }
        }
    }

    static void useBottle() {
        int adventurerId = scanner.nextInt();
        int bottleId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                boolean isUse = adventurer.useBottle(bottleId);
                if(isUse == false){

                }
            }
        }
    }
}
