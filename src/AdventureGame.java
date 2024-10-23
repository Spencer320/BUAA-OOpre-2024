import java.util.ArrayList;
import java.util.Arrays;

public class AdventureGame {
    public static void main(String[] args) {
        Adventurer adventurer = MainClass.adventurers.get(args[0]);
        ArrayList<Guard> guards = new ArrayList<>(Arrays.asList(
                new Shd(),
                new Flm(),
                new Stn(),
                new Wnd(),
                new Frz()
        ));
        for (Guard guard : guards) {
            if (guard.fight(adventurer)) {
                Treasure treasure = TreasureFactory.createTreasure(guard);
                treasure.showInfo();
                treasure.useBy(adventurer);
            } else {
                break;
            }
        }
    }

    interface Guard {
        boolean fight(Adventurer adventurer);

        String getType();
    }

    static class Shd implements Guard {
        @Override
        public boolean fight(Adventurer adventurer) {
            return adventurer.getComprehensiveCE() > 1000;
        }

        @Override
        public String getType() {
            return "Shd";
        }
    }

    static class Flm implements Guard {
        @Override
        public boolean fight(Adventurer adventurer) {
            return adventurer.getComprehensiveCE() > 2000;
        }

        @Override
        public String getType() {
            return "Flm";
        }
    }

    static class Stn implements Guard {
        @Override
        public boolean fight(Adventurer adventurer) {
            return adventurer.getComprehensiveCE() > 3000;
        }

        @Override
        public String getType() {
            return "Stn";
        }
    }

    static class Wnd implements Guard {
        @Override
        public boolean fight(Adventurer adventurer) {
            return adventurer.getComprehensiveCE() > 4000;
        }

        @Override
        public String getType() {
            return "Wnd";
        }
    }

    static class Frz implements Guard {
        @Override
        public boolean fight(Adventurer adventurer) {
            return adventurer.getComprehensiveCE() > 5000;
        }

        @Override
        public String getType() {
            return "Frz";
        }
    }

    interface Treasure {
        void showInfo();

        void useBy(Adventurer adventurer);
    }

    static class ShdTreasure implements Treasure {
        @Override
        public void showInfo() {
            System.out.println("Cloak of Shadows");
        }

        @Override
        public void useBy(Adventurer adventurer) {
            adventurer.updateDef(adventurer.getDef() + 40);
            adventurer.updateCe();
            for (Mercenary mercenary : adventurer.getMercenaries()) {
                Adventurer mercenaryAdventurer = mercenary.getAdventurer();
                mercenaryAdventurer.updateDef(mercenaryAdventurer.getDef() + 40);
                mercenaryAdventurer.updateCe();
            }
        }
    }

    static class FlmTreasure implements Treasure {
        @Override
        public void showInfo() {
            System.out.println("Flamebrand Sword");
        }

        @Override
        public void useBy(Adventurer adventurer) {
            adventurer.updateAtk(adventurer.getAtk() + 40);
            adventurer.updateCe();
            for (Mercenary mercenary : adventurer.getMercenaries()) {
                Adventurer mercenaryAdventurer = mercenary.getAdventurer();
                mercenaryAdventurer.updateAtk(mercenaryAdventurer.getAtk() + 40);
                mercenaryAdventurer.updateCe();
            }
        }
    }

    static class StnTreasure implements Treasure {
        @Override
        public void showInfo() {
            System.out.println("Stoneheart Amulet");
        }

        @Override
        public void useBy(Adventurer adventurer) {
            adventurer.updateDef(adventurer.getDef() + 40);
            adventurer.updateCe();
            for (Mercenary mercenary : adventurer.getMercenaries()) {
                Adventurer mercenaryAdventurer = mercenary.getAdventurer();
                mercenaryAdventurer.updateDef(mercenaryAdventurer.getDef() + 40);
                mercenaryAdventurer.updateCe();
            }
        }
    }

    static class WndTreasure implements Treasure {
        @Override
        public void showInfo() {
            System.out.println("Windrunner Boots");
        }

        @Override
        public void useBy(Adventurer adventurer) {
            adventurer.updateDef(adventurer.getDef() + 30);
            adventurer.updateCe();
            for (Mercenary mercenary : adventurer.getMercenaries()) {
                Adventurer mercenaryAdventurer = mercenary.getAdventurer();
                mercenaryAdventurer.updateDef(mercenaryAdventurer.getDef() + 30);
                mercenaryAdventurer.updateCe();
            }
        }
    }

    static class FrzTreasure implements Treasure {
        @Override
        public void showInfo() {
            System.out.println("Frostbite Staff");
        }

        @Override
        public void useBy(Adventurer adventurer) {
            adventurer.updateAtk(adventurer.getAtk() + 50);
            adventurer.updateCe();
            for (Mercenary mercenary : adventurer.getMercenaries()) {
                Adventurer mercenaryAdventurer = mercenary.getAdventurer();
                mercenaryAdventurer.updateAtk(mercenaryAdventurer.getAtk() + 50);
                mercenaryAdventurer.updateCe();
            }
        }
    }

    static class TreasureFactory {
        public static Treasure createTreasure(Guard guard) {
            switch (guard.getType()) {
                case "Shd":
                    return new ShdTreasure();
                case "Flm":
                    return new FlmTreasure();
                case "Stn":
                    return new StnTreasure();
                case "Wnd":
                    return new WndTreasure();
                case "Frz":
                    return new FrzTreasure();
                default:
                    throw new IllegalArgumentException("Unknown guard type");
            }
        }
    }
}