import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquipmentTest {

    @Test
    public void DurabilityTest(){
        Equipment Sample = new Equipment("0","Sample", 1, 0);
        int dur_now = Sample.getDurability();
        int dur_last = 0;
        for(int i=0;i<100;i++){
            assertEquals(dur_now,dur_last+1);
            Sample.increaseDurability();
            dur_last=dur_now;
            dur_now= Sample.getDurability();
        }
    }

}