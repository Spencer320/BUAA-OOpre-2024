public class Mercenary {
    private Adventurer adventurer;
    private int assistanceTimes;

    public Mercenary(Adventurer adventurer, int assistanceTimes) {
        this.adventurer = adventurer;
        this.assistanceTimes = assistanceTimes;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAssistanceTimes() {
        assistanceTimes += 1;
    }

    public int getAssistanceTimes() {
        return assistanceTimes;
    }
}
