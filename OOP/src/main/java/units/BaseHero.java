package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
    public String name;
    protected String className;
    protected int x, y;
    //    protected int initiative;
    protected float health, maxHealth;
    protected int attack;
    protected int defense;
    protected int[] damage;

    protected Position position;

    public BaseHero(String className, String name, int x, int y, float health, int attack, int defense, int[] damage) {
        this.className = className;
        this.name = name;
        this.position = new Position(x, y);
//        this.x = x;
//        this.y = y;
//        this.initiative = initiative;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
    }

    @Override
    public String toString() {
        x = this.position.getX();
        y = this.position.getY();
        return className + " " + name + ", x=" + x + ", y=" + y;
    }


    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String getInfo() {
        return className.toLowerCase();
    }


    public Float getHealth() {
        return this.health;
    }

    public BaseHero nearestEnemy(ArrayList<BaseHero> enemyList) {
        double minDistance = 10;
        BaseHero enemy = null;
        for (BaseHero e : enemyList) {
            if (e.getHealth() < 0) continue;
            if (minDistance > this.getPosition().getDistance(e.getPosition())) {
                minDistance = this.getPosition().getDistance(e.getPosition());
                enemy = e;
            }

        }
        return enemy;
    }


    public void setHealth(float health) {
        this.health = health;
    }
}
