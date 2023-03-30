package units;

public abstract class Melee extends BaseHero {
    int rage;
    int maxRage;

    public Melee(String className, String name, int x, int y, float health, int attack, int defense, int[] damage, int rage, int maxRage) {
        super(className, name, x, y, health, attack, defense, damage);
        this.rage = rage;
        this.maxRage = maxRage;
    }
}
