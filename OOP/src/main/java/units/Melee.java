package units;

public class Melee extends BaseHero {
    int rage;
    int maxRage;

    public Melee(String className, String name, int x, int y, int initiative, float health, int attack, int defense, int[] damage, int rage, int maxRage) {
        super(className, name, x, y, initiative, health, attack, defense, damage);
        this.rage = rage;
        this.maxRage = maxRage;
    }
}
