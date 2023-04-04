package units;

public final class Crossbowman extends Ranged {
    private static final String className = "Арбалетчик";

    public Crossbowman(String name, int x, int y) {
        super(className,name, 1, x, y, 8, 12, 3, new int[]{7,13}, 0,10, 75);
    }

//    @Override
//    public String getInfo() {
//        return "Я арбалетчик";
//    }
}
