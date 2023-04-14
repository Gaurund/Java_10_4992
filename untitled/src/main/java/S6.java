import java.util.ArrayList;
import java.util.HashMap;

public class S6 {
    public static void main(String[] args) {

        MySet mySet = new MySet();
        MySet newMySet = new MySet();
        mySet.add(13);
        mySet.add(1);
        mySet.add(1);
        newMySet.add(12);
        newMySet.add(1);
        newMySet.add(5);
        newMySet.add(8);
        newMySet.add(7);
        newMySet.add(15);


        mySet.unite(newMySet);
        mySet.print();
        mySet.delete(1);
        mySet.print();
        System.out.println(mySet.size());
        System.out.println(mySet.atIndex(2));
        System.out.println(mySet.toList());
        System.out.println(mySet.toListUpTo(12));
        System.out.println(mySet.toString());
    }
}

class MySet {

    private static final Object OBJECT = new Object();
    private final HashMap<Integer, Object> myset;

    public MySet() {
        this.myset = new HashMap<>();
    }

    public void add(Integer value) {
        this.myset.putIfAbsent(value, OBJECT);
    }

    public void delete(Integer value) {
        this.myset.remove(value);
    }

    public void print() {
        this.myset.forEach((k, v) -> System.out.print(k + " "));
        System.out.println();
    }

    public void unite(MySet otherset) {
        otherset.myset.forEach((k, v) -> this.add(k));
    }

    public int size() {
        return this.myset.size();
    }

    public int atIndex(int i) {
        return (int) this.myset.keySet().toArray()[i];
    }

    public ArrayList<Integer> toList() {
        return new ArrayList<>(this.myset.keySet());
    }

    public ArrayList<Integer> toListUpTo(int e) {
        if (!this.myset.containsKey(e)) return null;
        ArrayList<Integer> list = new ArrayList<>();
        for (int k : myset.keySet()) {
            list.add(k);
            if (k == e) break;
        }
        return list;
    }

    public String toString() {
        return this.myset.keySet().toString();
    }
}