import java.util.ArrayList;
import java.util.List;

public class ChainCombat extends Combat {
    private final int scanDepth = 5;
    private List<Adventurer> extendedRivals;

    public ChainCombat(Adventurer adventurer, List<Adventurer> rivals, Equipment equipment) {
        super(adventurer, rivals, equipment);
        for (int i = 0; i < scanDepth - 1; i++) {
            extendedRivals = scanEmploy(rivals);
        }
    }

    private List<Adventurer> scanEmploy(List<Adventurer> srcList) {
        List<Adventurer> desList = new ArrayList<>();
        for (Adventurer adventurer : srcList) {
            if (! desList.contains(adventurer)) {
                desList.add(adventurer);
            }
            for (Mercenary mercenary : adventurer.getMercenaries()) {
                Adventurer mercenaryAdventurer = mercenary.getAdventurer();
                if (! desList.contains(mercenaryAdventurer)) {
                    desList.add(mercenaryAdventurer);
                }
            }
        }
        return desList;
    }

    @Override
    public int getMaxDef() {
        int maxDef = 0;
        for (Adventurer rival : extendedRivals) {
            if (rival.getDef() > maxDef) {
                maxDef = rival.getDef();
            }
        }
        return maxDef;
    }

    @Override
    public void success() {
        int lossDef = 0;
        Equipment equipment = getEquipment();
        Adventurer adventurer = getAdventurer();
        for (Adventurer rival : extendedRivals) {
            int prevHp = rival.getHp();
            rival.updateHp(equipment.newHp(adventurer.getAtk(), rival.getDef(),rival.getHp()));
            int nowHp = rival.getHp();
            lossDef += (prevHp - nowHp);
        }
        System.out.println(lossDef);
        equipment.decreaseDurability();
        if (equipment.getDurability() == 0) {
            adventurer.deleteEquipment(equipment);
        }
    }
}
