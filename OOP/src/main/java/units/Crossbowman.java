package units;

public final class Crossbowman extends Ranged {
    private static final String className = "Арбалетчик";

    public Crossbowman(String name, int x, int y, int initiative) {
        super(className,name, x, y, initiative, 8, 12, 3, new int[]{7,13}, 10, 75);
    }

}
