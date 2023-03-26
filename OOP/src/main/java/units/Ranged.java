package units;

public abstract class Ranged extends BaseHero{
    int arrows;
    int accuracy;
    public Ranged(String className, String name, int x, int y, int initiative, float health, int attack, int defense, int[] damage, int arrows, int accuracy) {
        super(className, name, x, y, initiative, health, attack, defense, damage);
        this.arrows = arrows;
        this.accuracy = accuracy;
    }
}
