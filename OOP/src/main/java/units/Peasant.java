package units;

import java.util.ArrayList;

public final class Peasant extends BaseHero {
    public static final String className = "Крестьянин";

    public Peasant(String name, int side, int x, int y) {
        super(className, name, side, x, y, 3, 0, 1, 1, new int[]{1, 3}, 50);
    }

    private BaseHero isRangedExisted(ArrayList<BaseHero> armies) {
        for (BaseHero e : armies) {
            if (e instanceof Ranged && !isEnemy(e) && e.isWaiting() && e.getAmmo().isNotFull()) {
                return e;
            }
        }
        return null;
    }

    public void step(ArrayList<BaseHero> armies, Score score) {
        if (isDead(this)) {
            return;
        }
        BaseHero ranged = isRangedExisted(armies);
        if (ranged != null) {
            System.out.print(" - Пополняем боеприпасы посредством крестьянина " + name + " стрелку " + ranged.name + ". Было: ");
            ranged.getState().setBusy();
            this.getState().setBusy();
            System.out.print(ranged.getArrows());
            ranged.getAmmo().addArrow();
            System.out.print(", стало: " + ranged.getArrows() + "\n");
        }
    }

//    @Override
//    public String getInfo() {
//        return "Я крестьянин";
//    }
}
