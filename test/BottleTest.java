import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {
    Bottle bottle1 = new HpBottle("1","botName",0,100);
    Bottle bottle2 = new AtkBottle("2","botName",100,1005);
    Bottle bottle3 = new DefBottle("3","botName",100,1005);

    @Test
    //test function "useBottle"
    public void useBottle(){
        assertEquals(100,bottle1.getCapacity());
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

}