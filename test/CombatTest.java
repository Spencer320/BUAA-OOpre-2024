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
    Adventurer adventurer1 = new Adventurer("1000","Tomorin");
    Adventurer adventurer2 = new Adventurer("2000","Soyorin");
    Adventurer adventurer3 = new Adventurer("3000","name");
    Adventurer adventurer4 = new Adventurer("4000","name");
    Adventurer adventurer5 = new Adventurer("5000","name");
    Adventurer adventurer6 = new Adventurer("5000","name");
    Adventurer adventurer7 = new Adventurer("5000","name");
    Adventurer adventurer8 = new Adventurer("5000","name");
    Adventurer adventurer9 = new Adventurer("5000","name");
    Adventurer adventurer10 = new Adventurer("5000","name");
    Adventurer adventurer11 = new Adventurer("5000","name");
    Adventurer adventurer12 = new Adventurer("5000","name");


    List<Adventurer> rivals = new ArrayList<>();
    ItemStore itemStore = ItemStore.getInstance();

    public void setRivals() {
        rivals.add(rival1);
        rivals.add(rival2);
    }

    public void setAdventurer() {
        adventurer.updateAtk(121);
        rival1.updateDef(240);
        rival2.updateDef(200);
        rival1.updateHp(163);
        rival2.updateHp(2500);
    }

    public void setMercenary() {
        adventurer1.updateAtk(1000);
        adventurer1.updateDef(300);
        adventurer1.updateHp(500);
        adventurer2.updateAtk(4000);
        adventurer2.updateDef(0);
        adventurer2.updateHp(163);
        adventurer1.addEquipment(itemStore.createEquipment("600","Taki",1,100,"Blade"));
        adventurer2.addEquipment(itemStore.createEquipment("500","Anon",1,200,"Sword"));
    }

    public void setEquipment() {
        adventurer.addEquipment(itemStore.createEquipment("7","soyo",2,150,"Axe"));
        adventurer.addEquipment(itemStore.createEquipment("6","saki",1,100,"Blade"));
        adventurer.addEquipment(itemStore.createEquipment("5","taki",1,200,"Sword"));
        adventurer.carryItem("7");
        adventurer.carryItem("6");
        adventurer.carryItem("5");
    }

    //without taking "mercenary method" into consideration
    @Test
    public void isCombat(){
        setRivals();
        setAdventurer();
        setEquipment();
        HashMap<String,Equipment> equipmentHashMap = adventurer.getCarriedEquipments();
        for (Map.Entry<String, Equipment> entry : equipmentHashMap.entrySet()) {
            System.out.println("键: " + entry.getKey() + ", 值: " + entry.getValue());
        }

        Equipment equipment1 = adventurer.getCarriedEquipments().get("soyo");
        Equipment equipment2 = adventurer.getCarriedEquipments().get("saki");
        Equipment equipment3 = adventurer.getCarriedEquipments().get("taki");

        Combat combat1 = new NormalCombat(adventurer,rivals,equipment1);
        Combat combat2 = new NormalCombat(adventurer,rivals,equipment2);
        NormalCombat combat3 = new NormalCombat(adventurer,rivals,equipment3);

        assertTrue(combat1.isCombat());
        assertFalse(combat2.isCombat());
        assertTrue(combat3.isCombat());
        combat3.success();
        assertEquals(0, equipment3.getDurability());

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
        assertEquals(16,rival1.getHp());
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
        assertEquals(163 - 221,rival1.getHp());
    }

    @Test
    public void success_Sword() {
        setRivals();
        setAdventurer();
        setEquipment();
        Combat combat = new Combat(adventurer,rivals,adventurer.getCarriedEquipments().get("taki"));
        combat.success();
        assertEquals(82,rival1.getHp());
    }

    @Test
    public void failure() {
        setRivals();
        setAdventurer();
        setEquipment();
        Combat combat = new Combat(adventurer,rivals,adventurer.getCarriedEquipments().get("saki"));
        combat.failure();
    }
    //new test
    @Test
    //test defense
    public void chainTest1(){
        setRivals();
        setAdventurer();
        setEquipment();
        setMercenary();
        rival1.employAdventurer(adventurer1);
        rival1.employAdventurer(adventurer2);
        Equipment equipment1 = adventurer.getCarriedEquipments().get("soyo");
        Equipment equipment2 = adventurer.getCarriedEquipments().get("taki");
        ChainCombat combat1 = new ChainCombat(adventurer,rivals, equipment1);
        ChainCombat combat2 = new ChainCombat(adventurer,rivals, equipment2);
        System.out.println(combat1.getMaxDef());
        assertFalse(combat1.isCombat());
        assertTrue(combat2.isCombat());
    }

    @Test
    //test object
    public void chainTest2(){
        setRivals();
        setAdventurer();
        setEquipment();
        setMercenary();
        Equipment equipment = adventurer.getCarriedEquipments().get("taki");
        rival1.employAdventurer(adventurer1);
        rival1.employAdventurer(adventurer2);
        adventurer2.employAdventurer(adventurer3);
        adventurer3.employAdventurer(adventurer4);
        adventurer4.employAdventurer(adventurer5);
        adventurer5.employAdventurer(adventurer6);
        adventurer6.employAdventurer(adventurer7);
        adventurer7.employAdventurer(adventurer8);
        rival2.employAdventurer(adventurer8);
        adventurer8.employAdventurer(adventurer9);
        adventurer8.employAdventurer(adventurer10);
        adventurer10.employAdventurer(adventurer1);
        adventurer10.employAdventurer(adventurer);
        ChainCombat combat = new ChainCombat(adventurer,rivals,equipment);
        assertTrue(combat.isCombat());
        List<Adventurer> extendedRivals = combat.getExtendedRivals();
        assertTrue(extendedRivals.contains(adventurer5));
        assertFalse(extendedRivals.contains(adventurer6));
        assertTrue(extendedRivals.contains(adventurer10));
        int prevAllHp = 0;
        for (Adventurer extendedRival : extendedRivals) {
            prevAllHp += extendedRival.getHp();
        }
        combat.success();
        int nowAllHp = 0;
        for (Adventurer extendedRival : extendedRivals) {
            nowAllHp += extendedRival.getHp();
        }
        assertEquals(2791,prevAllHp-nowAllHp);
        assertEquals(500-321,adventurer10.getHp());
        assertEquals(500-321,adventurer.getHp());
    }

    @Test
    public void normalTest1(){
        setRivals();
        setAdventurer();
        setEquipment();
        setMercenary();
        adventurer1.carryItem("600");
        adventurer2.carryItem("500");
        rival1.employAdventurer(adventurer1);
        rival2.employAdventurer(adventurer1);
        rival2.employAdventurer(adventurer2);
        Equipment equipment = adventurer.getCarriedEquipments().get("taki");
        NormalCombat combat = new NormalCombat(adventurer,rivals,equipment);
        assertTrue(combat.isCombat());
        assertEquals(163,rival1.getHp());
        combat.success();
        assertEquals(82,rival1.getHp());
        assertFalse(rival2.getItems().containsKey("500"));
        assertFalse(rival1.getItems().containsKey("600"));
        assertFalse(rival2.getItems().containsKey("600"));
    }

    @Test
    public void normalTest2(){
        setRivals();
        setAdventurer();
        setEquipment();
        setMercenary();
        adventurer1.carryItem("600");
        adventurer2.carryItem("500");
        rival1.employAdventurer(adventurer1);
        rival2.employAdventurer(adventurer1);
        rival2.employAdventurer(adventurer2);
        Equipment equipment = adventurer.getCarriedEquipments().get("soyo");
        NormalCombat combat = new NormalCombat(adventurer,rivals,equipment);
        assertTrue(combat.isCombat());
        combat.success();
        combat.success();
        assertSame(rival2.getMercenaries().get(0).getAdventurer(), adventurer1);
        combat.success();
        assertSame(rival2.getMercenaries().get(0).getAdventurer(), adventurer1);
        combat.success();
        assertTrue(rival2.getMercenaries().isEmpty());
    }

    @Test
    public void normalTest3(){
        setRivals();
        setAdventurer();
        setEquipment();
        setMercenary();
        rival1.employAdventurer(adventurer1);
        rival2.employAdventurer(adventurer1);
        rival2.employAdventurer(adventurer2);
        Equipment equipment = adventurer.getCarriedEquipments().get("soyo");
        NormalCombat combat = new NormalCombat(adventurer,rivals,equipment);
        assertTrue(combat.isCombat());
        combat.success();
        assertFalse(rival2.getItems().containsKey("500"));
        assertTrue(adventurer1.getItems().containsKey("600"));
        assertFalse(rival2.getItems().containsKey("600"));
    }
}