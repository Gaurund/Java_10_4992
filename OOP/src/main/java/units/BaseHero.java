package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
    public String name;
    protected String className;
    protected Side side;
    protected int priority;
    protected Health health;
    protected double range;
    protected int attack;
    protected int defense;
    protected int[] damage;
    protected Position position;
    protected State state;

    public BaseHero(String className, String name, int side, int x, int y, float health, double range, int attack, int defense, int[] damage, int priority) {
        this.className = className;
        this.name = name;
        this.side = new Side(side);
        this.position = new Position(x, y);
        this.priority = randomizePriority(priority);
        this.health = new Health(health);
        this.range = range;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.state = new State();
    }

    @Override
    public String toString() {
        int x = this.position.getX();
        int y = this.position.getY();
        return side.getSideName() + " " + className + " " + name + " [x=" + x + ", y=" + y + "] ♥:" + this.getHealth() + " состояние: " + state.getStateName();
    }

    private int randomizePriority(int priority) {
        return new Random().nextInt(15) + priority;
    }

    /**
     * =======
     * Getters
     * =======
     */
    public int getPriority() {
        return priority;
    }

    @Override
    public int getSide() {
        return side.getSideID();
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public State getState() {
        return state;
    }


    public Float getHealth() {
        return health.getHealth();
    }

    /**
     * =======
     * Setters
     * =======
     */
//    public void setHealth(float health) {
//        this.health = health;
//    }

    public Ammo getAmmo() {
        return null;
    }

    public int getDefense() {
        return defense;
    }

    public int getArrows() {
        return 0;
    }

    public void getDamage(float damage){
        this.health.getDamage(damage);
    }
    @Override
    public String getInfo() {
        return className;
    }

    public void inflictDamage(BaseHero enemy, Score score) {
        float damage = (this.attack - enemy.getDefense()) + (new Random().nextInt(this.damage[1] - this.damage[0]) + this.damage[0]);
          damage = damage / 10;
        enemy.getDamage(damage);
//        System.out.print(" >>> Цель " + enemy.name + " получает урон " + damage);
        if (enemy.getHealth() <= 0) {
            enemy.die();
            score.decrementScore(enemy.getSide());
//            System.out.print(" и погибает");
        }
//        System.out.print(".\n");
    }

    public void upkeep() {
        if (!isDead(this) && isBusy(this)) {
            state.setWaiting();
        }
    }

    private boolean isBusy(BaseHero hero) {
        return hero.getState().isBusy(hero);
    }

    protected boolean isEnemy(BaseHero hero) {
        return hero.getSide() != this.getSide();
    }

    public boolean isWaiting() {
        return state.isWaiting(this);
    }

    public boolean isDead(BaseHero hero) {
        return hero.getState().isDead(hero);
    }

    public boolean isHidden(BaseHero hero) {
        return hero.getState().isHidden(hero);
    }

    public boolean isShielded(BaseHero hero) {
        return hero.getState().isShielded(hero);
    }

    public void die() {
        state.die();
    }

    public BaseHero nearestEnemy(ArrayList<BaseHero> armies) {
        double minDistance = 100;
        BaseHero enemy = null;
        for (BaseHero e : armies) {
            if (isDead(e) || isHidden(e) || isShielded(e)) continue;
            if (isEnemy(e)) {
                double estimatedDistance = position.getDistance(e.getPosition());
                if (minDistance > estimatedDistance) {
                    minDistance = estimatedDistance;
                    enemy = e;
                }
            }
        }

        return enemy;
    }

    public boolean checkRange(BaseHero enemy) {
        double distance = this.position.getDistance(enemy.getPosition());
        return distance < range;
    }

    protected boolean isHurt() {
        return this.health.isHurt();
    }
}
