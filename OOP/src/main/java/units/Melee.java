package units;

import java.util.ArrayList;

public abstract class Melee extends BaseHero {
    int rage;
    int maxRage;

    public Melee(String className, String name, int side, int x, int y, float health, double range, int attack, int defense, int[] damage, int priority, int rage, int maxRage) {
        super(className, name, side, x, y, health, range, attack, defense, damage, priority);
        this.rage = rage;
        this.maxRage = maxRage;
    }

    public void hit(BaseHero enemy, Score score) {
        System.out.println("KABOOM!!!");
    }

    public void step(ArrayList<BaseHero> armies, Score score) {
        if (isDead(this)) {
            return;
        }
        BaseHero nearestEnemy = nearestEnemy(armies);
        if (nearestEnemy != null) {
            if (checkRange(nearestEnemy)) {
                System.out.println(" >>> Цель: " + nearestEnemy);
                hit(nearestEnemy, score);
            } else {
                this.getPosition().move(nearestEnemy, armies);
            }
        }
        System.out.println();
    }


}
