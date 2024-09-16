import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    static ArrayList<Adventurer> adventurerArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int line = scanner.nextInt();
        int i = 0;
        while (i<line) {
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
    static public void createAdventurer(){
        int adv_id = scanner.nextInt();
        String name = scanner.next();
        Adventurer adventurer = new Adventurer(adv_id, name);
        adventurerArrayList.add(adventurer);
    }
    static public void addBottleForAdventurer(){
        int adv_id = scanner.nextInt();
        int bot_id = scanner.nextInt();
        String name = scanner.next();
        int capacity = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList){
            if(adventurer.getAdv_id() == adv_id){
                adventurer.addBottle(bot_id,name,capacity);
            }
        }
    }
    static public void addEquipmentForAdventurer(){
        int adv_id = scanner.nextInt();
        int equ_id = scanner.nextInt();
        String name = scanner.next();
        int durability = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList){
            if(adventurer.getAdv_id() == adv_id){
                adventurer.addEquipment(equ_id,name, durability);
            }
        }
    }
    static public void increaseDurability(){
        int adv_id = scanner.nextInt();
        int equ_id = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList){
            if(adventurer.getAdv_id() == adv_id){
                adventurer.increaseDurability(equ_id);
            }
        }
    }
    static public void deleteBottle(){
        int adv_id = scanner.nextInt();
        int bot_id = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList){
            if(adventurer.getAdv_id() == adv_id){
                adventurer.deleteBottle(bot_id);
            }
        }
    }
    static public void deleteEquipment(){
        int adv_id = scanner.nextInt();
        int equ_id = scanner.nextInt();
        for (Adventurer adventurer : adventurerArrayList){
            if(adventurer.getAdv_id() == adv_id){
                adventurer.deleteEquipment(equ_id);
            }
        }
    }
}
