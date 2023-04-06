package units;

import java.util.ArrayList;

public abstract class Healer extends BaseHero {
    int mana;
    int maxMana;
    int range;
    float restoreHealth;

    public Healer(String className, String name, int side, int x, int y, float health, int attack, int defense, int[] damage, int priority, float restoreHealth, int range) {
        super(className, name, side, x, y, health, attack, defense, damage, priority);
        this.mana = 100;
        this.maxMana = mana;
        this.range = range;
        this.restoreHealth = restoreHealth;
    }

    public void step(ArrayList<BaseHero> armies, Score score)  {
    }

}
