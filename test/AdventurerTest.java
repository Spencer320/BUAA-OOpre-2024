import org.junit.Test;


import java.util.HashMap;

import static org.junit.Assert.*;

public class AdventurerTest {
    Adventurer adventurer = new Adventurer(0,"Tester");
    HashMap<Integer,Item> items = adventurer.getItems();


    @Test
    //test function "addBottle"
    public void bottleTest1(){
        adventurer.addBottle(1,"botName",0,100,"HpBottle");
        adventurer.addBottle(2,"botName",100,1005,"AtkBottle");
        adventurer.addBottle(3,"botName",100,1005,"DefBottle");
        assertTrue(items.containsKey(1));
        Item item = items.get(1);
        assertTrue(item instanceof Bottle);
        Bottle bottle = (Bottle) items.get(1);
        assertEquals("HpBottle",bottle.getType());
        assertTrue(bottle instanceof HpBottle);
    }

    @Test
    //copy from "BottleTest" , test function "Bottle : useBottle"
    public void bottleTest2(){
        adventurer.addBottle(1,"botName",0,100,"HpBottle");
        adventurer.addBottle(2,"botName",100,1005,"AtkBottle");
        adventurer.addBottle(3,"botName",100,1005,"DefBottle");
        Bottle bottle1 =(Bottle) items.get(1);
        Bottle bottle2 =(Bottle) items.get(2);
        Bottle bottle3 =(Bottle) items.get(3);

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
        adventurer.addEquipment(0, "name", 100, 15);
        Equipment equipment = (Equipment) items.get(0);
        assertFalse(equipment.isCarried);
        int dur_now = equipment.getDurability();
        int dur_last = 14;
        for(int i=0;i<100;i++){
            assertEquals(dur_now,dur_last+1);
            adventurer.increaseDurability(0);
            dur_last=dur_now;
            dur_now= equipment.getDurability();
        }
        adventurer.carryItem(0);
        assertTrue(equipment.isCarried);
        adventurer.deleteItem(0);
        assertFalse(items.containsKey(0));
    }

    @Test
    //test function "carryBottle" and "useBottle"
    public void bottleTest3(){
        adventurer.addBottle(1,"botName",0,100,"HpBottle");
        adventurer.addBottle(2,"botName",100,1005,"AtkBottle");
        adventurer.addBottle(3,"botName",100,1005,"DefBottle");
        adventurer.useBottle(1);
        assertFalse(((Bottle) items.get(1)).isUsed());
        adventurer.carryItem(1);
        adventurer.carryItem(2);
        adventurer.carryItem(3);
        adventurer.useBottle(1);
        adventurer.useBottle(2);
        assertTrue(((Bottle) items.get(1)).isUsed());
        assertEquals(600,adventurer.getHp());
        assertEquals(111,adventurer.getAtk());
        assertEquals(0,adventurer.getDef());
        adventurer.useBottle(3);
        assertEquals(110,adventurer.getDef());
    }

}