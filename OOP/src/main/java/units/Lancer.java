package units;

public final class Lancer extends Melee {
    private static final String className = "Копейщик";
    public Lancer(String name, int x, int y) {
        super(className, name, x, y,  10, 14, 6, new int[]{7, 13}, 0, 4);

    }
//    @Override
//    public String getInfo() {
//        return "Я копейщик";
//    }
}
