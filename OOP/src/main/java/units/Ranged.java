package units;

public abstract class Ranged extends BaseHero{
    int arrows, maxArrows;
    int accuracy;
    public Ranged(String className, String name, int x, int y, int initiative, float health, int attack, int defense, int[] damage, int arrows, int accuracy) {
        super(className, name, x, y, initiative, health, attack, defense, damage);
        this.arrows = arrows;
        this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(){
        System.out.println("Shoot!");
    }
}
