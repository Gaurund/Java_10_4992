package units;

public class Position {
    private int heroX, heroY;

    public Position(int heroX, int heroY) {
        this.heroX = heroX;
        this.heroY = heroY;
    }

    public int getHeroX() {
        return heroX;
    }

    public int getHeroY() {
        return heroY;
    }

    @Override
    public String toString() {
        return "Позиция (" +
                "x = " + heroX +
                ", y = " + heroY +
                ')';
    }

    public double getDistance(Position enemyPosition){
        int enemyX = enemyPosition.getHeroX();
        int enemyY = enemyPosition.getHeroY();
        return Math.sqrt(((this.heroX - enemyX) * (this.heroX - enemyX)) + ((this.heroY - enemyY) * (this.heroY - enemyY)));
    }
}
