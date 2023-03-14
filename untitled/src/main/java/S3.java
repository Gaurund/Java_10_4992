import java.util.*;

public class S3 {

    public static void main(String[] args) {

        Object[] i = new Object[0];
        int u = i.length;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> strings = new ArrayList<>();
        strings.addAll(list);
        strings.clear();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.forEach(n -> System.out.print(n+","));
        System.out.println();
        list.remove(1);
        list.forEach(n -> System.out.print(n+","));
        System.out.println();
        list.add(list.size()/2, 7);
        list.forEach(n -> System.out.print(n+","));
        System.out.println();
        list.set(list.size()/2, 8);
        list.forEach(n -> System.out.print(n+","));
        System.out.println();
        Collections.sort(list);
        list.forEach(n -> System.out.print(n+","));
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                if ((t1-t0)%2 != 0) return 1;
                else if ((t1-t0)%2 == 0) return -1;
                return 0;
            }
        });
        list.forEach(n -> System.out.print(n+","));
        System.out.println();

        for (int j = 0; j < 5; j++) {
            list.add(new Random().nextInt(5));
            strings.add(new Random().nextInt(5));
        }

        System.out.println(list);
        System.out.println(strings);
        System.out.println("-".repeat(10));
        list.retainAll(strings);
//        list.removeAll(strings);
        System.out.println(list);

        list.forEach(n -> System.out.println(n));

        for (int n: list) {
            System.out.println(n);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            System.out.println(n);
            iterator.remove();
        }

        ListIterator<Integer> iterator1 = list.listIterator(list.size());
        while (iterator1.hasPrevious()){
            int n = iterator1.previous();
            System.out.println(n);
        }

        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(4);
        list1.get(3);
        list1.getFirst();

    }

}
