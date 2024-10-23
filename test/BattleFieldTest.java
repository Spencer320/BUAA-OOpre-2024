import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BattleFieldTest {
    BattleField battleField = BattleField.getInstance();
    List<Adventurer> adventurers =new ArrayList<>();
    @Test
    public void classTest() {
        adventurers.add(new Adventurer("2","b"));
        adventurers.add(new Adventurer("3","c"));
        Adventurer adventurer = new Adventurer("6","e");
        adventurer.updateDef(5000);
        adventurer.updateCe();
        adventurers.get(0).employAdventurer(adventurer);
        battleField.createCombat(new Adventurer("1","a"),adventurers,new Axe("4","d",10,5),"normal");
        battleField.battle();
        battleField.createCombat(new Adventurer("1","a"),adventurers,new Axe("4","d",10,5),"chain");
        battleField.battle();

    }

}