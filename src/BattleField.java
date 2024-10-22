import java.util.List;

public class BattleField {
    private static final BattleField battleField = new BattleField();
    private Combat combat;

    public static BattleField getInstance() {
        return battleField;
    }

    public Combat getCombat() {
        return combat;
    }

    public void createCombat(Adventurer adventurer, List<Adventurer> rivals,
                             Equipment equipment, String type) {
        switch (type) {
            case "normal":
                this.combat = new NormalCombat(adventurer,rivals,equipment);
                break;
            case "chain":
                this.combat = new ChainCombat(adventurer,rivals,equipment);
                break;
            default:
        }
    }

    public void battle() {
        boolean isCombat = combat.isCombat();
        if (isCombat) {
            combat.success();
        } else {
            combat.failure();
        }
    }
}
