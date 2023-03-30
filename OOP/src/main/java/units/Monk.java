package units;

public final class Monk extends Healer{
    private static final String className = "Монах";

    public Monk(String name, int x, int y) {
        super(className, name, x, y, 6, 13, 1, new int[]{7,13}, 3, 7);
    }

//    @Override
//    public String getInfo() {
//        return "Я монах";
//    }
}
