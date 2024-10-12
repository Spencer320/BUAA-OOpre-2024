public class Blade extends Equipment {
    public Blade(String id, String name, int ce, int durability) {
        super(id, name, ce, durability);
    }

    @Override
    public int newHp(int atk, int def, int hp) {
        return super.newHp(atk, def, hp) - def;
    }
}
