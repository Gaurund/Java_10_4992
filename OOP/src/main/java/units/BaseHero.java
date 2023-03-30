package units;

public abstract class BaseHero implements GameInterface {
    public String name;
    protected String className;
    protected int x, y;
    protected int initiative;
    protected float health, maxHealth;
    protected int attack;
    protected int defense;
    protected int[] damage;

    public BaseHero(String className, String name, int x, int y, int initiative, float health, int attack, int defense, int[] damage) {
        this.className = className;
        this.name = name;
        this.x = x;
        this.y = y;
        this.initiative = initiative;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return className + " " + name + ", x=" + x + ", y=" + y;
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return null;
    }

}
