package units;

public final class Rogue extends Melee{
    private static final String className = "Разбойник";
    public Rogue(String name, int x, int y, int initiative) {
        super(className, name, x, y, initiative, 9, 15, 5, new int[]{8,14}, 0, 3);

    }

}
