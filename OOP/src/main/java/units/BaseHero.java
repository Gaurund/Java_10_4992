package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
    public String name;
    protected String className;
    protected Side sideID;
    protected int priority;
    protected float health, maxHealth;
    protected int attack;
    protected int defense;
    protected int[] damage;
    protected Position position;
    protected State state;

    public BaseHero(String className, String name, int sideID, int x, int y, float health, int attack, int defense, int[] damage, int priority) {
        this.className = className;
        this.name = name;
        this.sideID = new Side(sideID);
        this.position = new Position(x, y);
        this.priority = randomizePriority(priority);
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.state = new State();
    }

    @Override
    public String toString() {
        int x = this.position.getX();
        int y = this.position.getY();
        return className + " " + name + " (" + sideID.getSideName() + ") [x=" + x + ", y=" + y + "] ♥:" + this.getHealth() + " состояние: " + state.getStateName();
    }

    private int randomizePriority(int priority) {
        return new Random().nextInt(15) + priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int getSideID() {
        return sideID.getSideID();
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
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public String getInfo() {
        return className.toLowerCase();
    }

    public void upkeep() {
        if (state.getStateID() > 0) {
//            System.out.println("Check 1: " + name + " --> " + state.getStateID());
            state.changeState(1);
//            System.out.println("Check 2: " + name + " --> " + state.getStateID());
        }
    }

    public BaseHero nearestEnemy(ArrayList<BaseHero> enemyList) {
        double minDistance = 10;
        BaseHero enemy = null;
        for (BaseHero e : enemyList) {
            if (e.getState().getStateID() == 0) continue;
            double estimatedDistance = position.getDistance(e.getPosition());
            if (minDistance > estimatedDistance) {
                minDistance = estimatedDistance;
                enemy = e;
            }
        }
        return enemy;
    }
}
