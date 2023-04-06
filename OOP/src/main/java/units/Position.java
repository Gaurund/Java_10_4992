package units;

public class Position {
    private int heroX, heroY;

    public Position(int heroX, int heroY) {
        this.heroX = heroX;
        this.heroY = heroY;
    }

    public int getX() {
        return heroX;
    }

    public int getY() {
        return heroY;
    }

    @Override
    public String toString() {
        return "Позиция (" +
                "x = " + heroX +
                ", y = " + heroY +
                ')';
    }

    public double getDistance(Position enemyPosition) {
        int enemyX = enemyPosition.getX();
        int enemyY = enemyPosition.getY();
        return Math.sqrt(((this.heroX - enemyX) * (this.heroX - enemyX)) + ((this.heroY - enemyY) * (this.heroY - enemyY)));
    }

    public Boolean move(String move) {
        int HIGH_LIMIT = 10;
        int LOW_LIMIT = 1;
        switch (move) {
            case "влево":
                if (this.heroX == LOW_LIMIT) return false;
                heroX -= 1;
                return true;
            case "вправо":
                if (this.heroX == HIGH_LIMIT) return false;
                heroX += 1;
                return true;
            case "вверх":
                if (this.heroY == LOW_LIMIT) return false;
                heroY -= 1;
                return true;
            case "вниз":
                if (this.heroY == HIGH_LIMIT) return false;
                heroY += 1;
                return true;
        }
        return null; // Без этой "заглушки" компилятор выдаёт ошибку.
    }
}
