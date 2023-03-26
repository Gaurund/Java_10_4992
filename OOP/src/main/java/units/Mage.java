package units;

public final class Mage extends Healer{

    private static final String className = "Маг";

    public Mage(String name, int x, int y, int initiative) {
        super(className, name, x, y, initiative, 5, 12, 1, new int[]{6,12}, 4,5);
    }

}
