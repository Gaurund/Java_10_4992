package units;

public final class Peasant extends BaseHero{
    public static final String className = "Крестьянин";
    int load;
    int capacity;
    public Peasant(String name, int x, int y, int initiative) {
        super(className, name, x, y, initiative, 3, 1, 1, new int[]{1,3});
        this.load = 3;
        this.capacity = 3;
    }
}
