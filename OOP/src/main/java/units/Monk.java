package units;

public final class Monk extends Healer{
    private static final String className = "Монах";

    public Monk(String name, int x, int y, int initiative) {
        super(className, name, x, y, initiative, 6, 13, 1, new int[]{7,13}, 3, 7);
    }

}
