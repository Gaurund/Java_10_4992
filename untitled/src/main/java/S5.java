import java.util.*;

public class S5 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i,String.valueOf(i));
            hashMap.putIfAbsent(i,String.valueOf(i)+"!");
        }
//        hashMap.forEach((k, v) -> System.out.print(k+"="+v+", "));

        Set<Integer> keys = hashMap.keySet();

        for (Integer k:keys) {
            System.out.print(hashMap.get(k)+", ");
        }

        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()){
            String v = hashMap.get(iterator.next());
            System.out.print(v + ", ");
//            iterator.remove();
        }

        System.out.println(hashMap);

        Collection<String> vl = hashMap.values();

        hashMap.getOrDefault(21, "Key isn't found");
        hashMap.containsKey(31); // Вернёт булево
        hashMap.replace(1, "2"); // Перезапишет содержимое
        hashMap.compute(3, (k,va)-> va += "!"); // Позволяет итерировать и изменять одновременно

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("Первый", "1");
        treeMap.put("Второй", "1");
        treeMap.put("Третий", "1");
        treeMap.put("Пятый", "1");
        treeMap.headMap("Второй", true);
        treeMap.tailMap("Второй", false);

        System.out.println(hashMap);

    }
}
