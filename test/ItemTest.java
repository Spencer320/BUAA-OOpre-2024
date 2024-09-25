import org.junit.Test;
import static org.junit.Assert.*;


public class ItemTest {
    @Test
    public void getType (){
        Item bottle1 =new Bottle(0,"name",100,100,"AtkBottle") ;
        assertEquals("AtkBottle",bottle1.getType());
        Item bottle2 =new Bottle(0,"name",100,100,"DefBottle") ;
        assertEquals("DefBottle",bottle2.getType());
        Item bottle3 =new Bottle(0,"name",100,100,"HpBottle") ;
        assertEquals("HpBottle", bottle3.getType());
        Item equipment =new Equipment(0,"name", 100, 100);
        assertEquals("Equipment",equipment.getType());
    }

}