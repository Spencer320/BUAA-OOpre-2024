import org.junit.Test;
import static org.junit.Assert.*;

public class MainClassTest {

    @Test
    public void createAdventurer() {
        int id=000000;
        String name = "Sample";
        Adventurer Sample = new Adventurer(id, name);
        MainClass.adventurerArrayList.add(Sample);
        assertTrue(MainClass.adventurerArrayList.contains(Sample));
    }

    @Test
    public void addBottleForAdventurer() {

    }

    @Test
    public void addEquipmentForAdventurer() {
    }

    @Test
    public void increaseDurability() {
    }

    @Test
    public void deleteBottle() {
    }

    @Test
    public void deleteEquipment() {
    }
}