package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Ranged extends BaseHero {
    int arrows, maxArrows;
    int accuracy;

    public Ranged(String className, String name, int side, int x, int y, float health, int attack, int defense, int[] damage, int priority, int arrows, int accuracy) {
        super(className, name, side, x, y, health, attack, defense, damage, priority);
        this.arrows = arrows;
        this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(BaseHero enemy, Score score) {
        Random chance = new Random();
        arrows = arrows - 1;
        if (chance.nextInt(101) < accuracy) {
            float damage = (attack - enemy.getDefense()) + (new Random().nextInt(this.damage[1] - this.damage[0]) + this.damage[0]);
//            damage = damage / 10;
            enemy.setHealth(enemy.getHealth() - damage);
            System.out.println(enemy.name + " получает урон " + damage);
            if (enemy.getHealth() <= 0) {
                enemy.getState().changeState(0);
                score.decrementScore(enemy.getSide());
            }
            System.out.println(enemy);
        } else {
            System.out.println("Стрела прошла мимо!");
        }
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
    public void step(ArrayList<BaseHero> armies, Score score) {
        if (isDead(this)) {
            return;
        }

        if (isNotEmpty()) {
            BaseHero nearestEnemy = nearestEnemy(armies);
            if (nearestEnemy != null) {
                System.out.println("Цель: " + nearestEnemy);
                shoot(nearestEnemy, score);
            }
        }
        System.out.println();

    }

    @Override
    public String toString() {
        return super.toString() + " [Стрел: "+arrows+"]";
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public int getMaxArrows() {
        return maxArrows;
    }

    public void setPlusOneArrow() {
        this.arrows += 1;
    }
}
