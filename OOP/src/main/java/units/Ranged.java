package units;
/**
 * Проверить живой ли он?
 * Проверить есть ли стрелы?
 * Если стрелы есть и он живой, тогда найти ближайшего противника и выстрелить в него.
 * После выстрела, проверить есть ли свой крестьянин? Если есть, то просто завершить работу.
 * Если нет, то количество стрел уменьшить на один.
 * */
public abstract class Ranged extends BaseHero{
    int arrows, maxArrows;
    int accuracy;
    public Ranged(String className, String name, int x, int y, float health, int attack, int defense, int[] damage, int arrows, int accuracy) {
        super(className, name, x, y,health, attack, defense, damage);
        this.arrows = arrows;
        this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(){
        System.out.println("Shoot!");
    }

    protected boolean isDead(){
        return this.health > 0;
    }

    protected boolean isEmpty(){
        return this.arrows > 0;
    }

    public void step(){
        if(isDead() || isEmpty()) {
            System.out.println("Dead of out of arrows");
        }
    }
}
