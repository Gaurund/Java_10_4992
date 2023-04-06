package units;

public class Score {
    private final int[] score = new int[2];

    public Score() {
        this.score[0] = 10;
        this.score[1] = 10;
    }

    public void decrementScore(int sideID) {
        score[sideID] -= 1;
    }

    public Integer checkScore() {
        if (score[0] == 0) return 1;
        if (score[1] == 0) return 0;
        return null;
    }

    @Override
    public String toString() {
        return "\nУ Белых в живых: " + score[0] + "\nУ Чёрных в живых: " + score[1];
    }
}
