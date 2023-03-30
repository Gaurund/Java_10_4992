package units;

public abstract class Healer extends BaseHero{
    int mana;
    int maxMana;
    int range;
    float restoreHealth;
    public Healer(String className, String name, int x, int y, float health, int attack, int defense, int[] damage, float restoreHealth, int range) {
        super(className, name, x, y, health, attack, defense, damage);
        this.mana = 100;
        this.maxMana = mana;
        this.range = range;
        this.restoreHealth = restoreHealth;
    }
}
