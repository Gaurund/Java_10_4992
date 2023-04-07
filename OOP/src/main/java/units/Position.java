package units;

import java.util.ArrayList;

public class Position {
    private final int[] positionArr;

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
        if (checkBorders(mainDimension, sign) && checkCell(mainDimension, offDimension, sign, armies)) {
            this.positionArr[mainDimension] += sign;
            return;
        }
        counter += 1;
        if (counter == 1) {
            moveXY(counter, offDimension, mainDimension, sign, armies);
        } else if (counter == 2) {
            moveXY(counter, mainDimension, offDimension, -sign, armies);
        }
    }

    private boolean checkCell(int mainDimension, int offDimension, int sign, ArrayList<BaseHero> armies) {
        int result = positionArr[mainDimension] + sign;
        for (BaseHero e : armies) {
            if (!e.isDead(e) && e.position.positionArr[offDimension] == positionArr[offDimension] && e.position.positionArr[mainDimension] == result) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBorders(int dimension, int sign) {
        int result = positionArr[dimension] + sign;
        return result > 0 && result < 11;
    }

}
