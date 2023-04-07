package units;

import java.util.ArrayList;
import java.util.Arrays;

public class Position {
    //    private final int heroX;
//    private final int heroY;
    private int[] positionArr;

    public Position(int heroX, int heroY) {
        this.positionArr = new int[2];
        this.positionArr[0] = heroX;
        this.positionArr[1] = heroY;
    }

    public int getX() {
        return positionArr[0];
    }

    public int getY() {
        return positionArr[1];
    }

    @Override
    public String toString() {
        return "Позиция (" +
                "x = " + this.getX() +
                ", y = " + this.getY() +
                ')';
    }

    public int[] getDirection(Position enemyPosition) {
        int enemyX = enemyPosition.getX();
        int enemyY = enemyPosition.getY();
        return new int[]{enemyX - getX(), enemyY - getY()};
    }

    public double getDistance(Position enemyPosition) {
        int enemyX = enemyPosition.getX();
        int enemyY = enemyPosition.getY();
        return Math.sqrt(((this.getX() - enemyX) * (this.getX() - enemyX)) + ((this.getY() - enemyY) * (this.getY() - enemyY)));
    }

    private int getSing(int number) {
        if (number > 0) return 1;
        else if (number < 0) return -1;
        return 0;
    }

    public void move(BaseHero enemy, ArrayList<BaseHero> armies) {
        int[] direction = getDirection(enemy.getPosition());
        int x = direction[0];
        int y = direction[1];
        int leftOrRight = getSing(x);
        int upOrDown = getSing(y);
        if (Math.abs(x) >= Math.abs(y)) {
            moveXY(0, 0, 1, leftOrRight, armies);
        } else {
            moveXY(0, 1, 0, upOrDown, armies);
        }
    }

    private void moveXY(int counter, int mainDimension, int offDimension, int sign, ArrayList<BaseHero> armies) {
        if (checkBorders(mainDimension, sign) && checkCell(mainDimension, sign, armies)) {
            positionArr[mainDimension] += sign;
            return;
        }
        counter += 1;
        if (counter < 2) moveXY(counter, offDimension, mainDimension, sign, armies);
        else if (counter == 3) moveXY(counter, mainDimension, offDimension, -sign, armies);
    }

    private boolean checkCell(int dimension, int sign, ArrayList<BaseHero> armies) {
        int result = positionArr[dimension] + sign;
        for (BaseHero e : armies) {
            if (!e.isDead(e) && e.position.positionArr[dimension] == result) return false;
        }
        return true;
    }

    private boolean checkBorders(int dimension, int sign) {
        int result = positionArr[dimension] + sign;
        return result > 0 && result < 11;
    }
//    public Boolean move(String move) {
//        int HIGH_LIMIT = 10;
//        int LOW_LIMIT = 1;
//        switch (move) {
//            case "влево":
//                if (this.heroX == LOW_LIMIT) return false;
//                heroX -= 1;
//                return true;
//            case "вправо":
//                if (this.heroX == HIGH_LIMIT) return false;
//                heroX += 1;
//                return true;
//            case "вверх":
//                if (this.heroY == LOW_LIMIT) return false;
//                heroY -= 1;
//                return true;
//            case "вниз":
//                if (this.heroY == HIGH_LIMIT) return false;
//                heroY += 1;
//                return true;
//        }
//        return null; // Без этой "заглушки" компилятор выдаёт ошибку.
//    }
}
