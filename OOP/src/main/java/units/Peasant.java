package units;

public final class Peasant extends BaseHero{
    public static final String className = "Крестьянин";
    int load;
    int capacity;
    public Peasant(String name, int x, int y) {
        super(className, name, x, y, 3, 1, 1, new int[]{1,3});
        this.load = 3;
        this.capacity = 3;
    }
//    @Override
//    public String getInfo() {
//        return "Я крестьянин";
//    }
}
