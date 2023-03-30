package units;

public final class Archer extends Ranged {
    private static final String className = "Лучник";

    public Archer(String name, int x, int y) {
        super(className, name, x, y, 7, 12, 2, new int[]{6, 12}, 15, 70);
    }

//    @Override
//    public String getInfo() {
//        return "Я лучник";
//    }

}
