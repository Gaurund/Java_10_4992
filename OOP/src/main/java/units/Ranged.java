package units;

import java.util.ArrayList;

/**
 * Проверить живой ли он?
 * Проверить есть ли стрелы?
 * Если стрелы есть и он живой, тогда найти ближайшего противника и выстрелить в него.
 * После выстрела, проверить есть ли свой крестьянин? Если есть, то просто завершить работу.
 * Если нет, то количество стрел уменьшить на один.
 */
public abstract class Ranged extends BaseHero {
    int arrows, maxArrows;
    int accuracy;

    public Ranged(String className, String name, int x, int y, float health, int attack, int defense, int[] damage, int arrows, int accuracy) {
        super(className, name, x, y, health, attack, defense, damage);
        this.arrows = arrows;
        this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot() {
        System.out.println("Shoot!");
    }

    protected boolean isDead() {
        return this.health <= 0;
    }

    protected boolean isEmpty() {
        return this.arrows <= 0;
    }

    protected boolean isPeasantExisted(ArrayList<BaseHero> teamList) {
        for (BaseHero e : teamList) {
            if (e instanceof Peasant) return true;
        }
        return false;
    }

    @Override
    public void step (ArrayList<BaseHero> enemyList, ArrayList<BaseHero> teamList) {
        if (isDead()) {
            System.out.println("Стрелок скорее мёртв, чем жив.");
            return;
        }
        if (isEmpty()) {
            if (isPeasantExisted(teamList)) {
                System.out.println("Пополняем боеприпасы.");
                this.arrows = this.maxArrows;
            } else {
                System.out.println("Это конец. Стрел уже не будет.");
                return;
            }
        }
        BaseHero nearestEnemy = nearestEnemy(enemyList);
        System.out.println(nearestEnemy);
        System.out.println("Стреляем в него и вычисляем урон.");
    }
}
