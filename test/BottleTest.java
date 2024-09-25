import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {
    Bottle bottle1 = new HpBottle(1,"botName",0,100,"HpBottle");
    Bottle bottle2 = new AtkBottle(2,"botName",100,1005,"AtkBottle");
    Bottle bottle3 = new DefBottle(3,"botName",100,1005,"DefBottle");

    @Test
    //test function "useBottle"
    public void useBottle(){
        assertEquals(false, bottle1.isUsed());
        assertEquals(false, bottle2.isUsed());
        assertEquals(false, bottle3.isUsed());
        int value = bottle1.useBottle();
        assertEquals(100,value);
        assertEquals(true, bottle1.isUsed());
        value = bottle2.useBottle();
        assertEquals(110,value);
        assertEquals(true, bottle2.isUsed());
        value = bottle3.useBottle();
        assertEquals(110,value);
        assertEquals(true, bottle3.isUsed());
    }

}