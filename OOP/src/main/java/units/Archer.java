package units;

public final class Archer extends Ranged {
    private static final String className = "Лучник";

    public Archer(String name, int x, int y, int initiative) {
        super(className, name, x, y, initiative, 7, 12, 2, new int[]{6, 12}, 15, 70);
    }

}
