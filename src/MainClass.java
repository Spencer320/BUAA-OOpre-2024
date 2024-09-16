import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        ArrayList<Adventurer> adventurerArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int i = 0;
        while (i<line) {
            i++;
            String command = scanner.next();
            if ("1".equals(command)) {
                int adv_id = scanner.nextInt();
                String name = scanner.next();
                Adventurer adventurer = new Adventurer(adv_id, name);
                adventurerArrayList.add(adventurer);
            } else if ("2".equals(command)) {
                int adv_id = scanner.nextInt();
                int bot_id = scanner.nextInt();
                String name = scanner.next();
                int capacity = scanner.nextInt();
                for (Adventurer adventurer : adventurerArrayList){
                    if(adventurer.getAdv_id() == adv_id){
                        adventurer.addBottle(bot_id,name,capacity);
                    }
                }
            } else if ("3".equals(command)) {
                int adv_id = scanner.nextInt();
                int equ_id = scanner.nextInt();
                String name = scanner.next();
                int durability = scanner.nextInt();
                for (Adventurer adventurer : adventurerArrayList){
                    if(adventurer.getAdv_id() == adv_id){
                        adventurer.addEquipment(equ_id,name, durability);
                    }
                }
            } else if ("4".equals(command)) {
                int adv_id = scanner.nextInt();
                int equ_id = scanner.nextInt();
                for (Adventurer adventurer : adventurerArrayList){
                    if(adventurer.getAdv_id() == adv_id){
                        adventurer.increaseDurability(equ_id);
                    }
                }
            } else if ("5".equals(command)) {
                int adv_id = scanner.nextInt();
                int bot_id = scanner.nextInt();
                for (Adventurer adventurer : adventurerArrayList){
                    if(adventurer.getAdv_id() == adv_id){
                        adventurer.deleteBottle(bot_id);
                    }
                }
            } else if ("6".equals(command)) {
                int adv_id = scanner.nextInt();
                int equ_id = scanner.nextInt();
                for (Adventurer adventurer : adventurerArrayList){
                    if(adventurer.getAdv_id() == adv_id){
                        adventurer.deleteEquipment(equ_id);
                    }
                }
            }
        }
    }



}
