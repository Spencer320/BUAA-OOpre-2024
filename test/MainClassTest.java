import org.junit.Test;
import static org.junit.Assert.*;

public class MainClassTest {

    @Test
    public void createAdventurer() {
        Adventurer Sample = new Adventurer(0, "name");
        MainClass.adventurerArrayList.add(Sample);
        assertTrue(MainClass.adventurerArrayList.contains(Sample));
    }

}