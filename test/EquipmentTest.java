import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquipmentTest {
    Equipment equipment1 = new Axe("1","equName",100,1);
    Equipment equipment2 = new Sword("2","equName",100,5);
    Equipment equipment3 = new Blade("3","equName",100,5);

    @Test
    public void DurabilityTest(){
        Equipment Sample = new Equipment("0","Sample", 1, 1);
        int dur_now = Sample.getDurability();
        int dur_last = 0;
        for(int i=0;i<100;i++){
            assertEquals(dur_now,dur_last+1);
            Sample.increaseDurability();
            dur_last=dur_now;
            dur_now= Sample.getDurability();
        }
        dur_last=dur_now;
        for(int i=0;i<100;i++){
            Sample.decreaseDurability();
            dur_now= Sample.getDurability();
            assertEquals(dur_now+1,dur_last);
            dur_last=dur_now;
        }
    }

    @Test
    public void newHp(){
        assertEquals(50,equipment1.newHp(105,50,505));
        assertEquals(345,equipment2.newHp(105,50,500));
        assertEquals(295,equipment3.newHp(105,50,500));
    }

}