package units;

import java.util.ArrayList;

public abstract class Healer extends BaseHero {
    int mana;
    int maxMana;
    float restoreHealth;

    public Healer(String className, String name, int side, int x, int y, float health, double range, int attack, int defense, int[] damage, int priority, float restoreHealth) {
        super(className, name, side, x, y, health, range, attack, defense, damage, priority);
        this.mana = 100;
        this.maxMana = mana;
       this.restoreHealth = restoreHealth;
    }

    public void step(ArrayList<BaseHero> armies, Score score)  {
    }

}
