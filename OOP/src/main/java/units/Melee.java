package units;

import units.BaseHero;

import java.util.ArrayList;

public abstract class Melee extends BaseHero {
    int rage;
    int maxRage;

    public Melee(String className, String name, int sideID, int x, int y, float health, int attack, int defense, int[] damage, int priority, int rage, int maxRage) {
        super(className, name, sideID, x, y, health, attack, defense, damage, priority);
        this.rage = rage;
        this.maxRage = maxRage;
    }

    public void step(ArrayList<BaseHero> enemyList, ArrayList<BaseHero> teamList) {
    }

}
