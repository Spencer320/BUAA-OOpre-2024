import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


public class ItemTest {
    Adventurer adventurer = new Adventurer("0","Tester");
    HashMap<String, Item> items = adventurer.getItems();
    HashMap<String,Equipment> carriedEquipments = adventurer.getCarriedEquipments();
    ItemStore itemStore = ItemStore.getInstance();
    @Test
    public void getType (){
        Item bottle1 = itemStore.createBottle(String.valueOf(1),"botName",0,100,"HpBottle");
        Item bottle2 = itemStore.createBottle(String.valueOf(2),"botName",100,1005,"AtkBottle");
        Item bottle3 = itemStore.createBottle(String.valueOf(3),"botName",100,1005,"DefBottle");
        adventurer.addBottle(bottle1);
        adventurer.addBottle(bottle2);
        adventurer.addBottle(bottle3);
        Item equipment = itemStore.createEquipment("4","name",100,100, "Sword");
        adventurer.addEquipment(equipment);
        Item item1 = items.get("1");
        Item item2 = items.get("2");
        Item item3 = items.get("3");
        Item item4 = items.get("4");
        assertEquals("HpBottle",item1.getType());
        assertEquals("AtkBottle",item2.getType());
        assertEquals("DefBottle", item3.getType());
        assertEquals("Sword",item4.getType());
    }

}