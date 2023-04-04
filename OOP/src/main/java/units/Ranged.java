package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Ranged extends BaseHero {
    int arrows, maxArrows;
    int accuracy;

    public Ranged(String className, String name, int sideID, int x, int y, float health, int attack, int defense, int[] damage, int priority, int arrows, int accuracy) {
        super(className, name, sideID, x, y, health, attack, defense, damage, priority);
        this.arrows = 1;
        this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(BaseHero enemy) {
        Random chance = new Random();
        if (chance.nextInt(101) < accuracy) {
            float damage = (attack - enemy.getDefense());
            damage = damage / 10;
            enemy.setHealth(enemy.getHealth() - damage);
            arrows = arrows - 1;
            System.out.println(enemy.name + " получает урон " + damage);
            if (enemy.getHealth() <= 0) enemy.getState().changeState(0);
            System.out.println(enemy);
        } else {
            System.out.println("Стрела прошла мимо!");
        }
    }

    protected boolean isDead() {
        return state.getStateID() == 0;
    }

    protected boolean isNotEmpty() {
        return arrows > 0;
    }

    protected BaseHero isPeasantExisted(ArrayList<BaseHero> teamList) {
        for (BaseHero e : teamList) {
            if ((e instanceof Peasant) && (e.getState().getStateID() == 1)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void step(ArrayList<BaseHero> enemyList, ArrayList<BaseHero> teamList) {
        if (isDead()) {
            return;
        }

        if (isNotEmpty()) {
            BaseHero nearestEnemy = nearestEnemy(enemyList);
            System.out.println("Цель: " + nearestEnemy);
            shoot(nearestEnemy);
            BaseHero peasant = isPeasantExisted(teamList);
            if (peasant != null) {
                System.out.println("Пополняем боеприпасы посредством крестьянина " + peasant.name);
                this.arrows = this.maxArrows;
                peasant.getState().changeState(2);
                System.out.println("Теперь крестьянин " + peasant.name + " " + peasant.state.getStateName());
            } else {
                System.out.println("Не осталось свободных крестьян.");
            }
        }
        System.out.println();
    }
}
