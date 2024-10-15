import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CombatTest {
    Adventurer adventurer = new Adventurer("10086","adv");
    Adventurer rival1 = new Adventurer("10010","r1");
    Adventurer rival2 = new Adventurer("10011","r2");
    List<Adventurer> rivals = new ArrayList<>();

    public void setRivals() {
        rivals.add(rival1);
        rivals.add(rival2);
    }

    public void setAdventurer() {
        adventurer.addBottle("8","anon",100,2000,"AtkBottle");
        adventurer.carryItem("8");
        adventurer.useBottle("8");
        rival1.addBottle("88","anon",220,2000,"DefBottle");
        rival1.carryItem("88");
        rival1.useBottle("88");
        rival2.addBottle("888","anon",180,2000,"DefBottle");
        rival2.carryItem("888");
        rival2.useBottle("888");
        rival2.addBottle("8888","anon",0,2000,"HpBottle");
        rival2.carryItem("8888");
        rival2.useBottle("8888");
    }

    public void setEquipment() {
        adventurer.addEquipment("7","soyo",2,150,"Axe");
        adventurer.addEquipment("6","saki",1,100,"Blade");
        adventurer.addEquipment("5","taki",1,200,"Sword");
        adventurer.carryItem("7");
        adventurer.carryItem("6");
        adventurer.carryItem("5");
    }

    @Test
    public void isCombat(){
        setRivals();
        setAdventurer();
        setEquipment();
        assertEquals(121,adventurer.getAtk());
        assertEquals(240,rival1.getDef());
        assertEquals(200,rival2.getDef());
        assertEquals(500,rival1.getHp());
        assertEquals(2500,rival2.getHp());
        HashMap<String,Equipment> equipmentHashMap = adventurer.getCarriedEquipments();
        for (Map.Entry<String, Equipment> entry : equipmentHashMap.entrySet()) {
            System.out.println("键: " + entry.getKey() + ", 值: " + entry.getValue());
        }

        Equipment equipment1 = adventurer.getCarriedEquipments().get("soyo");
        Equipment equipment2 = adventurer.getCarriedEquipments().get("saki");
        Equipment equipment3 = adventurer.getCarriedEquipments().get("taki");

        Combat combat1 = new Combat(adventurer,rivals,equipment1);
        Combat combat2 = new Combat(adventurer,rivals,equipment2);
        Combat combat3 = new Combat(adventurer,rivals,equipment3);

        assertTrue(combat1.isCombat());
        assertFalse(combat2.isCombat());
        assertTrue(combat3.isCombat());
        combat3.success();

        Equipment equipment4 = adventurer.getCarriedEquipments().get("taki");
        Combat combat4 = new Combat(adventurer,rivals, equipment4);
        assertFalse(combat4.isCombat());

    }

    @Test
    public void success_Axe() {
        setRivals();
        setAdventurer();
        setEquipment();
        Combat combat = new Combat(adventurer,rivals,adventurer.getCarriedEquipments().get("soyo"));
        combat.success();
        assertEquals(1,adventurer.getCarriedEquipments().get("soyo").getDurability());
        assertEquals(50,rival1.getHp());
        assertEquals(250,rival2.getHp());
    }

    @Test
    public void success_Blade() {
        setRivals();
        setAdventurer();
        setEquipment();
        Combat combat = new Combat(adventurer,rivals,adventurer.getCarriedEquipments().get("saki"));
        combat.success();
        assertFalse(adventurer.getCarriedEquipments().containsKey("saki"));
        assertFalse(adventurer.getItems().containsKey("6"));
        assertEquals(500 - 221,rival1.getHp());
    }

    @Test
    public void success_Sword() {
        setRivals();
        setAdventurer();
        setEquipment();
        Combat combat = new Combat(adventurer,rivals,adventurer.getCarriedEquipments().get("taki"));
        combat.success();
        assertEquals(500-200-121+240,rival1.getHp());
    }

    @Test
    public void failure() {
        setRivals();
        setAdventurer();
        setEquipment();
        Combat combat = new Combat(adventurer,rivals,adventurer.getCarriedEquipments().get("saki"));
        combat.failure();
    }
}