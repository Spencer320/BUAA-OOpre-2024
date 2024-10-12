public class Axe extends Equipment {
    public Axe(String id, String name, int ce, int durability) {
        super(id, name, ce, durability);
    }

    @Override
    public int newHp(int atk, int def, int hp) {
        return hp / 10;
    }
}
