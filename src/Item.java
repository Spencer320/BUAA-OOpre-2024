public class Item {
    protected final int id;
    protected final String name;
    protected final int CE;
    protected boolean isCarried;

    public Item(int id, String name,int CE) {
        this.id = id;
        this.name = name;
        this.CE = CE;
        this.isCarried = false;
    }

    public String getName() {
        return name;
    }


    public String getType() {
        Item item = this;
        if (item instanceof Bottle){
            return item.getType();
        } else if (item instanceof Equipment) {
            return "Equipment";
        } else {
            return "Error";
        }
    }
}
