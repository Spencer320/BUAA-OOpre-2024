public class Bottle {
    private int bot_id;
    private String name;
    private int capacity;

    public int getBot_id() {
        return bot_id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Bottle(int bot_id, String name, int capacity){
        this.bot_id = bot_id;
        this.name = name;
        this.capacity = capacity;
    }

}
