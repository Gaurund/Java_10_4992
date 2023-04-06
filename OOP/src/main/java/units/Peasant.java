package units;

import java.util.ArrayList;

public final class Peasant extends BaseHero {
    public static final String className = "Крестьянин";
    int load;
    int capacity;

    public Peasant(String name, int side, int x, int y) {
        super(className, name, side, x, y, 3, 1, 1, new int[]{1, 3}, 50);
        this.load = 3;
        this.capacity = 3;
    }

    private BaseHero isRangedExisted(ArrayList<BaseHero> armies) {
        for (BaseHero e : armies) {
            if (e instanceof Ranged && e.getState().getStateID() == 1 && e.getArrows() != e.getMaxArrows() && !isEnemy(e)) {
                System.out.println(e + " должен получить стрелы от " + this.name);
                return e;
            }
        }
        return null;
    }

    public void step(ArrayList<BaseHero> armies) {
        if (isDead()) {
            return;
        }
        BaseHero ranged = isRangedExisted(armies);
        if (ranged != null) {
            System.out.print("Пополняем боеприпасы посредством крестьянина " + name + " стрелку " + ranged.name + ". Было: ");
            ranged.getState().changeState(2);
            System.out.print(ranged.getArrows());
            ranged.setPlusOneArrow();
            System.out.print(", стало: " + ranged.getArrows() + "\n");
        }
    }

//    @Override
//    public String getInfo() {
//        return "Я крестьянин";
//    }
}
