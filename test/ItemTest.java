import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


public class ItemTest {
    Adventurer adventurer = new Adventurer("0","Tester");
    HashMap<String, Item> items = adventurer.getItems();
    HashMap<String,Equipment> carriedEquipments = adventurer.getCarriedEquipments();
    @Test
    public void getType (){
        adventurer.addBottle("1","name",100,100,"AtkBottle");
        adventurer.addBottle("2","name",100,100,"DefBottle");
        adventurer.addBottle("3","name",100,100,"HpBottle");
        adventurer.addEquipment("4","name",100,100, "Sword");
        Item item1 = items.get("1");
        Item item2 = items.get("2");
        Item item3 = items.get("3");
        Item item4 = items.get("4");
        assertEquals("class AtkBottle",item1.getType());
        assertEquals("class DefBottle",item2.getType());
        assertEquals("class HpBottle", item3.getType());
        assertEquals("class Sword",item4.getType());
    }

}