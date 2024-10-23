import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AdventureGameTest {
    @Test
    public void test1(){
        Adventurer adventurer = new Adventurer("0","name");
        adventurer.updateDef(1000);
        adventurer.updateAtk(990);
        adventurer.updateCe();
        ArrayList<AdventureGame.Guard> guards = new ArrayList<>(Arrays.asList(
                new AdventureGame.Shd(),
                new AdventureGame.Flm(),
                new AdventureGame.Stn(),
                new AdventureGame.Wnd(),
                new AdventureGame.Frz()
        ));
        for (AdventureGame.Guard guard : guards) {
            if (guard.fight(adventurer)) {
                AdventureGame.Treasure treasure = AdventureGame.TreasureFactory.createTreasure(guard);
                treasure.showInfo();
                treasure.useBy(adventurer);
            }
        }
    }
    @Test
    public void test2(){
        Adventurer adventurer = new Adventurer("0","name");
        Adventurer adventurer1 = new Adventurer("1","name");
        adventurer.employAdventurer(adventurer1);
        adventurer.updateDef(1000);
        adventurer.updateAtk(990);
        adventurer.updateCe();
        adventurer1.updateDef(1000);
        adventurer1.updateAtk(990);
        adventurer1.updateCe();
        ItemStore itemStore = ItemStore.getInstance();
        Equipment equipment = (Equipment) itemStore.createEquipment("3","My",5,1000,"Sword");
        adventurer1.addEquipment(equipment);
        adventurer1.carryItem("3");
        ArrayList<AdventureGame.Guard> guards = new ArrayList<>(Arrays.asList(
                new AdventureGame.Shd(),
                new AdventureGame.Flm(),
                new AdventureGame.Stn(),
                new AdventureGame.Wnd(),
                new AdventureGame.Frz()
        ));
        for (AdventureGame.Guard guard : guards) {
            if (guard.fight(adventurer)) {
                AdventureGame.Treasure treasure = AdventureGame.TreasureFactory.createTreasure(guard);
                treasure.showInfo();
                treasure.useBy(adventurer);
            }
        }
    }
    @Test
    public void test3(){
        Adventurer adventurer = new Adventurer("0","name");
        Adventurer adventurer1 = new Adventurer("1","name");
        adventurer.employAdventurer(adventurer1);
        adventurer.updateDef(1000);
        adventurer.updateAtk(990);
        adventurer.updateCe();
        adventurer1.updateDef(100);
        adventurer1.updateAtk(990);
        adventurer1.updateCe();
        ItemStore itemStore = ItemStore.getInstance();
        Equipment equipment = (Equipment) itemStore.createEquipment("3","My",5,1000,"Sword");
        adventurer.addEquipment(equipment);
        adventurer.carryItem("3");
        ArrayList<AdventureGame.Guard> guards = new ArrayList<>(Arrays.asList(
                new AdventureGame.Shd(),
                new AdventureGame.Flm(),
                new AdventureGame.Stn(),
                new AdventureGame.Wnd(),
                new AdventureGame.Frz()
        ));
        for (AdventureGame.Guard guard : guards) {
            if (guard.fight(adventurer)) {
                System.out.println(adventurer.getComprehensiveCE());
                AdventureGame.Treasure treasure = AdventureGame.TreasureFactory.createTreasure(guard);
                treasure.showInfo();
                treasure.useBy(adventurer);
            }
        }
    }
}