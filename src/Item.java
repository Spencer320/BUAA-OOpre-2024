public class Item {
    private final int id;
    private final String name;
    private final int ce;
    private boolean isCarried;

    public boolean isCarried() {
        return isCarried;
    }

    public void setCarried(boolean carried) {
        isCarried = carried;
    }

    public Item(int id, String name, int ce) {
        this.id = id;
        this.name = name;
        this.ce = ce;
        this.isCarried = false;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        Item item = this;
        if (item instanceof Bottle) {
            return item.getType();
        } else if (item instanceof Equipment) {
            return "Equipment";
        } else {
            return "Error";
        }
    }
}
