import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class HomeWork05 {

    public static void main(String[] args) {

        HashMap<String, String> namesMap = new HashMap<>();
        HashMap<String, Integer> counterMap = new HashMap<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        namesMap.put("Иванов", "Иван");
        namesMap.put("Петрова", "Светлана");
        namesMap.put("Белова", "Кристина");
        namesMap.put("Мусина", "Анна");
        namesMap.put("Крутова", "Анна");
        namesMap.put("Юрин", "Иван");
        namesMap.put("Лыков", "Петр");
        namesMap.put("Чернов", "Павел");
        namesMap.put("Чернышов", "Петр");
        namesMap.put("Федорова", "Мария");
        namesMap.put("Светлова", "Марина");
        namesMap.put("Савина", "Мария");
        namesMap.put("Рыкова", "Мария");
        namesMap.put("Лугова", "Марина");
        namesMap.put("Владимирова", "Анна");
        namesMap.put("Мечников", "Иван");
        namesMap.put("Петин", "Петр");
        namesMap.put("Ежов", "Иван");

        for (String value : namesMap.values()) {
            if (counterMap.containsKey(value)) {
                counterMap.compute(value, (k, v) -> v + 1);
            } else {
                counterMap.put(value, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(counterMap.values());

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer num : list) {
            for (Entry<String, Integer> entry : counterMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }

        System.out.println(sortedMap);
    }
}
