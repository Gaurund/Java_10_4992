package units;

public final class Lancer extends Melee {
    private static final String className = "Копейщик";
    public Lancer(String name, int x, int y, int initiative) {
        super(className, name, x, y, initiative, 10, 14, 6, new int[]{7, 13}, 0, 4);

    }

}
