import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.Assert.*;

public class AdventurerTest {
    @Test
    public void addBottle() {
        Bottle bottle1 =new Bottle(0,"name",100,1005,"AtkBottle") ;
        assertEquals("AtkBottle",bottle1.getType());
        Bottle bottle2 =new Bottle(0,"name",100,1005,"DefBottle") ;
        assertEquals("DefBottle",bottle2.getType());
        Bottle bottle3 =new Bottle(0,"name",0,100,"HPBottle") ;
        assertEquals("HPBottle", bottle3.getType());
    }

    @Test
    public void equipmentTest() {
        Equipment equipment = new Equipment(0, "name", 100, 15);
        int dur_now = equipment.getDurability();
        int dur_last = 14;
        for(int i=0;i<100;i++){
            assertEquals(dur_now,dur_last+1);
            equipment.increaseDurability();
            dur_last=dur_now;
            dur_now= equipment.getDurability();
        }
    }

}