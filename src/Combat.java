import java.util.List;

public class Combat {
    private final Adventurer adventurer;
    private final List<Adventurer> rivals;
    private final Equipment equipment;

    public Combat(Adventurer adventurer, List<Adventurer> rivals, Equipment equipment) {
        this.adventurer = adventurer;
        this.rivals = rivals;
        this.equipment = equipment;
    }

    public List<Adventurer> getRivals() {
        return rivals;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getMaxDef() {
        int maxDef = 0;
        for (Adventurer rival : rivals) {
            if (rival.getDef() > maxDef) {
                maxDef = rival.getDef();
            }
        }
        return maxDef;
    }

    public boolean isCombat() {
        return equipment != null && adventurer.getAtk() + equipment.getCe() > getMaxDef();
    }

    public void success() {
        for (Adventurer rival : rivals) {
            rival.updateHp(equipment.newHp(adventurer.getAtk(), rival.getDef(),rival.getHp()));
            System.out.println(rival.getName() + " " + rival.getHp());
        }
        equipment.decreaseDurability();
        if (equipment.getDurability() == 0) {
            adventurer.deleteEquipment(equipment);
        }
    }

    public void failure() {
        System.out.println("Adventurer " + adventurer.getId() + " defeated");
    }
}
