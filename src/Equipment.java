public class Equipment {
    private int equ_id;
    private String name;
    private int durability;

    public int getEqu_id() {
        return equ_id;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public Equipment(int equ_id, String name, int durability) {
        this.equ_id = equ_id;
        this.name = name;
        this.durability = durability;
    }

    public void increaseDurability(){
        this.durability = this.durability +1;
    }

}
