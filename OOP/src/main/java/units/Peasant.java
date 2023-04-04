package units;

import java.util.ArrayList;

/**
 * Один крестьянин за ход обслуживает только одного стрелка.
 */
public final class Peasant extends BaseHero {
    public static final String className = "Крестьянин";
    int load;
    int capacity;

    public Peasant(String name, int sideID, int x, int y) {
        super(className, name, sideID, x, y, 3, 1, 1, new int[]{1, 3}, 50);
        this.load = 3;
        this.capacity = 3;
    }


    public void step(ArrayList<BaseHero> enemyList, ArrayList<BaseHero> teamList) {
    }

    //    @Override
//    public String getInfo() {
//        return "Я крестьянин";
//    }
}
