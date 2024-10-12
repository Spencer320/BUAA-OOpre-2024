import java.util.List;

public class Combat {
    private Adventurer adventurer;
    private List<Adventurer> rivals;
    private Equipment equipment;

    public Combat(Adventurer adventurer, List<Adventurer> rivals, Equipment equipment) {
        this.adventurer = adventurer;
        this.rivals = rivals;
        this.equipment = equipment;
    }

    public boolean isCombat() {
        int maxDef = 0;
        for (Adventurer rival : rivals) {
            if (rival.getDef() > maxDef) {
                maxDef = rival.getDef();
            }
        }
        return equipment != null && adventurer.getAtk() + equipment.getCe() > maxDef;
    }

    public void success() {
        for (Adventurer rival : rivals) {
            rival.updateHp(equipment.newHp(adventurer.getAtk(), rival.getDef(),rival.getHp()));
            System.out.println(rival.getName() + " " + rival.getHp());
        }
        equipment.decreaseDurability();
        if (equipment.getDurability() == 0) {
            adventurer.deleteEquipment(equipment, equipment.getId(), equipment.getName());
        }
    }

    public void failure() {
        System.out.println("Adventurer " + adventurer.getId() + " defeated");
    }
}
