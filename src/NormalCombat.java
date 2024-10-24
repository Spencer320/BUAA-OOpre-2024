import java.util.ArrayList;
import java.util.List;

public class NormalCombat extends Combat {
    public NormalCombat(Adventurer adventurer, List<Adventurer> rivals, Equipment equipment) {
        super(adventurer, rivals, equipment);
    }

    @Override
    public void success() {
        ArrayList<Integer> prevHp = new ArrayList<>();
        for (Adventurer rival : getRivals()) {
            prevHp.add(rival.getHp());
        }
        super.success();
        for (int i = 0; i < getRivals().size(); i++) {
            Adventurer rival = getRivals().get(i);
            int nowHp = rival.getHp();
            if (nowHp <= prevHp.get(i) / 2) {
                ArrayList<Mercenary> mercenaries = rival.getMercenaries();
                ArrayList<Mercenary> removedMercenaries = new ArrayList<>();
                for (Mercenary mercenary : mercenaries) {
                    mercenary.setAssistanceTimes();
                    Adventurer merAdventurer = mercenary.getAdventurer();
                    List<Equipment> equipmentToTransfer =
                            new ArrayList<>(merAdventurer.getCarriedEquipments().values());
                    for (Equipment equipment : equipmentToTransfer) {
                        assistance(merAdventurer, rival, equipment);
                        merAdventurer.deleteEquipment(equipment);
                    }
                    int maxAssistanceTimes = 3;
                    if (mercenary.getAssistanceTimes() > maxAssistanceTimes) {
                        removedMercenaries.add(mercenary);
                    }
                }
                mercenaries.removeAll(removedMercenaries);
            }
        }
    }

    public void assistance(Adventurer giver, Adventurer receiver, Equipment equipment) {
        giver.deleteEquipment(equipment);
        receiver.addEquipment(equipment);
    }
}
