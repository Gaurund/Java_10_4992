package units;

public final class Mage extends Healer {

    private static final String className = "Маг";

    public Mage(String name, int x, int y) {
        super(className, name, 1, x, y, 5, 7, 12, 1, new int[]{6, 12}, 30, 4);
    }
//    @Override
//    public String getInfo() {
//        return "Я маг";
//    }
}
