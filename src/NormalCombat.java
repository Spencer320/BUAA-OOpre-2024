import java.util.ArrayList;
import java.util.List;

public class NormalCombat extends Combat {
    public NormalCombat(Adventurer adventurer, List<Adventurer> rivals, Equipment equipment) {
        super(adventurer, rivals, equipment);
    }

    @Override
    public void success() {
        super.success();
        for (Adventurer rival : getRivals()) {
            ArrayList<Mercenary> mercenaries = rival.getMercenaries();
            for (Mercenary mercenary : mercenaries) {
                mercenary.setAssistanceTimes();
                Adventurer mercenaryAdventurer = mercenary.getAdventurer();
                for (Equipment equipment : mercenaryAdventurer.getCarriedEquipments().values()) {
                    assistance(mercenaryAdventurer,rival,equipment);
                }
                int maxAssistanceTimes = 3;
                if (mercenary.getAssistanceTimes() > maxAssistanceTimes) {
                    rival.getMercenaries().remove(mercenary);
                }
            }
        }
    }

    public void assistance(Adventurer giver,Adventurer receiver,Equipment equipment) {
        giver.deleteEquipment(equipment);
        receiver.addEquipment(equipment);
        receiver.getItems().put(equipment.getId(), equipment);
    }
}
