import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class AdventurerTest {
    Adventurer adventurer = new Adventurer("0","Tester");
    HashMap<String, Item> items = adventurer.getItems();
    HashMap<String,Equipment> carriedEquipments = adventurer.getCarriedEquipments();
    HashMap<String, HashMap<String, Bottle>> carriedBottles = adventurer.getCarriedBottles();
    ItemStore itemStore = ItemStore.getInstance();
    Item bottle1 = itemStore.createBottle(String.valueOf(1),"botName",0,100,"HpBottle");
    Item bottle2 = itemStore.createBottle(String.valueOf(2),"botName",100,1005,"AtkBottle");
    Item bottle3 = itemStore.createBottle(String.valueOf(3),"botName",100,1005,"DefBottle");


    @Test
    public void adventurerInfo(){
        assertEquals("0",adventurer.getId());
        assertEquals("Tester",adventurer.getName());
    }

    @Test
    //test function "addBottle"
    public void bottleTest1(){
        adventurer.addBottle(bottle1);
        adventurer.addBottle(bottle2);
        adventurer.addBottle(bottle3);
        assertTrue(items.containsKey("1"));
        Item item = items.get("1");
        assertTrue(item instanceof Bottle);
        Bottle bottle = (Bottle) items.get("1");
        assertEquals("HpBottle",bottle.getType());
        assertTrue(bottle instanceof HpBottle);
    }

    @Test
    //copy from "BottleTest" , test function "Bottle : useBottle"
    public void bottleTest2(){
        adventurer.addBottle(bottle1);
        adventurer.addBottle(bottle2);
        adventurer.addBottle(bottle3);
        Bottle bottle1 =(Bottle) items.get("1");
        Bottle bottle2 =(Bottle) items.get("2");
        Bottle bottle3 =(Bottle) items.get("3");

        assertFalse(bottle1.isUsed());
        assertFalse(bottle2.isUsed());
        assertFalse(bottle3.isUsed());
        int value = bottle1.useBottle();
        assertEquals(100,value);
        assertTrue(bottle1.isUsed());
        value = bottle2.useBottle();
        assertEquals(110,value);
        assertTrue(bottle2.isUsed());
        value = bottle3.useBottle();
        assertEquals(110,value);
        assertTrue(bottle3.isUsed());
    }

    @Test
    //test function "addEquipment" and "increaseDurability"
    public void equipmentTest() {
        Item item = itemStore.createEquipment(String.valueOf(0), "name", 15, 100, "Sword");
        adventurer.addEquipment(item);
        Equipment equipment = (Equipment) adventurer.getItems().get("0");
        assertFalse(carriedEquipments.containsKey("name"));
        int dur_now = equipment.getDurability();
        int dur_last = 14;
        for(int i=0;i<100;i++){
            assertEquals(dur_now,dur_last+1);
            itemStore.increaseDurability(equipment);
            dur_last=dur_now;
            dur_now= equipment.getDurability();
        }
        adventurer.carryItem(String.valueOf(0));
        assertFalse(carriedEquipments.isEmpty());
        assertTrue(carriedEquipments.containsKey("name"));
        adventurer.deleteItem(String.valueOf(0));
        assertFalse(items.containsKey("0"));
    }

    @Test
    //test function "carryBottle" and "useBottle"
    public void bottleTest3(){
        adventurer.addBottle(bottle1);
        adventurer.addBottle(bottle2);
        adventurer.addBottle(bottle3);

        adventurer.useBottle(String.valueOf(1));
        assertFalse(((Bottle) items.get("1")).isUsed());

        adventurer.carryItem(String.valueOf(1));
        adventurer.carryItem(String.valueOf(2));
        adventurer.useBottle(String.valueOf(1));
        adventurer.useBottle(String.valueOf(2));
        assertEquals(600,adventurer.getHp());
        assertTrue(((Bottle) items.get("1")).isUsed());
        assertNotEquals(111,adventurer.getAtk());

        adventurer.useBottle(String.valueOf(1));
        adventurer.carryItem(String.valueOf(2));
        adventurer.useBottle(String.valueOf(2));
        assertEquals(111,adventurer.getAtk());
        adventurer.carryItem(String.valueOf(3));
        assertEquals(0,adventurer.getDef());
        adventurer.useBottle(String.valueOf(3));
        assertEquals(110,adventurer.getDef());
        assertFalse(items.containsKey("1"));
        assertTrue(items.containsKey("3"));
    }

    @Test
    public void packTest (){
        Bottle bottle1 = new Bottle("500","Water Bottle", 500,500);
        Bottle bottle2 = new Bottle("499","Soda Bottle", 350,500);
        Bottle bottle3 = new Bottle("498","Water Bottle", 500,500);
        Bottle bottle4 = new Bottle("497","Water Bottle", 500,500);
        Bottle bottle5 = new Bottle("496","Soda Bottle", 350,500);
        adventurer.addBottle(itemStore.createBottle(String.valueOf(2),"botName",8,10,"AtkBottle"));
        adventurer.carryItem(String.valueOf(2));
        adventurer.useBottle(String.valueOf(2));
        assertEquals(2,adventurer.getCe()/5+1);
        adventurer.carryBottle(bottle1);
        adventurer.carryBottle(bottle2);
        adventurer.carryBottle(bottle3);
        adventurer.carryBottle(bottle4);
        adventurer.carryBottle(bottle5);

        HashMap<String,Bottle> waters = carriedBottles.getOrDefault("Water Bottle",new HashMap<>());
        HashMap<String,Bottle> sodas = carriedBottles.getOrDefault("Soda Bottle",new HashMap<>());
        assertFalse(waters.containsKey("497"));
        assertTrue(sodas.containsKey("496"));
    }

    @Test
    public void fragmentTest(){
        Fragment fragment = new Fragment("1","frag");
        adventurer.addFragment("1","fragment");
        adventurer.addFragment("2","fragment");
        adventurer.addFragment("3","fragment");
        adventurer.addFragment("4","fragment");
        adventurer.addFragment("5","fragment");
        adventurer.addFragment("6","fragment");
        adventurer.addFragment("7","fragment");
        adventurer.addFragment("8","fragment");
        adventurer.useFragment("123456","fragment");
        adventurer.useFragment("23456","fragment");
        adventurer.addFragment("9","fragment");
        adventurer.addFragment("10","fragment");
        adventurer.addFragment("11","fragment");
        adventurer.addEquipment( itemStore.createEquipment("3456","md",1,100,"Sword"));
        adventurer.useFragment("3456","fragment");

    }

    @Test
    public void mercenaryTest(){
        Adventurer adventurer1 = new Adventurer("100","Tomorin");
        Adventurer adventurer2 = new Adventurer("200","Soyorin");
        adventurer.employAdventurer(adventurer1);
        adventurer.employAdventurer(adventurer2);
        assertEquals(adventurer.getMercenaries().get(0).getAdventurer(), adventurer1);
        assertEquals(3,adventurer.getComprehensiveCE());
    }
}