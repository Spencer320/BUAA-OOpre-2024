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
                Adventurer adventurer = getAdventurer();
                if (adventurer != null) {
                    adventurer.addBottle();
                }
            } else if ("3".equals(command)) {
                Adventurer adventurer = getAdventurer();
                if (adventurer != null) {
                    adventurer.addEquipment();
                }
            } else if ("4".equals(command)) {
                Adventurer adventurer = getAdventurer();
                if (adventurer != null) {
                    adventurer.increaseDurability();
                }
            } else if ("5".equals(command)) {
                Adventurer adventurer = getAdventurer();
                if (adventurer != null) {
                    adventurer.deleteItem();
                }
            } else if ("6".equals(command)) {
                Adventurer adventurer = getAdventurer();
                if (adventurer != null) {
                    adventurer.carryItem();
                }
            } else if ("7".equals(command)) {
                Adventurer adventurer = getAdventurer();
                if (adventurer != null) {
                    adventurer.useBottle();
                }
            }
        }
    }

    static void createAdventurer() {
        int adventurerId = scanner.nextInt();
        String name = scanner.next();
        Adventurer adventurer = new Adventurer(adventurerId, name);
        adventurerArrayList.add(adventurer);
    }

    static Adventurer getAdventurer(){
        int adventurerId = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList) {
            if (adventurer.getId() == adventurerId) {
                return adventurer;
            }
        }
        return null;
    }

}
