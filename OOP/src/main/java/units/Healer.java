package units;

import units.BaseHero;

import java.util.ArrayList;
import java.util.Random;

public abstract class Healer extends BaseHero {
    int mana;
    int maxMana;
    int range;
    float restoreHealth;
    public Healer(String className, String name, int sideID, int x, int y, float health, int attack, int defense, int[] damage, int priority, float restoreHealth, int range) {
        super(className, name, sideID, x, y, health, attack, defense, damage, priority);
        this.mana = 100;
        this.maxMana = mana;
        this.range = range;
        this.restoreHealth = restoreHealth;
    }

    public void step(ArrayList<BaseHero> enemyList, ArrayList<BaseHero> teamList){};

}
