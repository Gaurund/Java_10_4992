import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class HomeWork03 {

    public static void main(String[] args) {
//        1. Реализовать алгоритм сортировки списков слиянием
        ArrayList<Integer> randomIntList = createRndIntList(10, 100);
        System.out.println("Исходный список случайных чисел:");
        System.out.println(randomIntList);
        MergeSort(randomIntList);
        System.out.println("Список отсортированный слиянием:");
        System.out.println(randomIntList);

//        2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
        randomIntList = createRndIntList(10, 100);
        System.out.println("Исходный список случайных чисел:");
        System.out.println(randomIntList);
        randomIntList = removeEvenNumbers(randomIntList);
        System.out.println("Список без чётных чисел:");
        System.out.println(randomIntList);

//        3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        randomIntList = createRndIntList(10, 100);
        System.out.println("\nЦелочисленный список: ");
        showMaxMinMedianOfList(randomIntList);

//        4. Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
        System.out.println();
        ArrayList<Integer> list1 = createRndIntList(10, 10);
        System.out.println("Первый список:\n" + list1);
        ArrayList<Integer> list2 = createRndIntList(10, 10);
        System.out.println("Второй список:\n" + list2);
        for (int e : list2) {
            if (!list1.contains(e)) {
                list1.add(e);
            }
        }
        System.out.println("Результат объединения:\n" + list1);

//        5. Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
        final int TEST_LIMIT = 100_000;
        ArrayList<Integer> arrayListOfZeroes = new ArrayList<>();
        long beginArrayList = System.currentTimeMillis();
        for (int i = 0; i < TEST_LIMIT; i++) {
            arrayListOfZeroes.add(0, 0);
        }
        long endArrayList = System.currentTimeMillis();
        System.out.println("\nРабота ArrayList: " + (endArrayList - beginArrayList));

//        6. Повторить пятый пункт но с LinkedList.
        LinkedList<Integer> linkedListOfZeroes = new LinkedList<>();
        long beginLinkedList = System.currentTimeMillis();
        for (int i = 0; i < TEST_LIMIT; i++) {
            linkedListOfZeroes.add(0, 0);
        }
        long endLinkedList = System.currentTimeMillis();
        System.out.println("\nРабота LinkedList: " + (endLinkedList - beginLinkedList));

//        7. Сравнить время работы пятого и шестого пунктов.
    }

    private static ArrayList<Integer> MergeSort(ArrayList<Integer> list) {

        if (list.size() <= 1) {
            return list;
        }
        int middle = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(list.subList(middle, list.size()));
        MergeSort(left);
        MergeSort(right);

        int i = 0, j = 0, k = 0;
        while (i < left.size() & j < right.size()) {
            if (left.get(i) < right.get(j)) {
                list.set(k, left.get(i));
                i = i + 1;
            } else {
                list.set(k, right.get(j));
                j = j + 1;
            }
            k = k + 1;
        }
        while (i < left.size()){
            list.set(k, left.get(i));
            i = i + 1;
            k = k + 1;
        }
        while (i < right.size()){
            list.set(k, right.get(j));
            j = j + 1;
            k = k + 1;
        }
        return list;
    }

    private static ArrayList<Integer> createRndIntList(int limit, int rndBound) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            list.add(new Random().nextInt(rndBound));
        }
        return list;
    }

    private static ArrayList<Integer> removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        return list;
    }

    private static void showMaxMinMedianOfList(ArrayList<Integer> list) {
        System.out.println(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println("Его минимльное значение: "
                + list.get(0));
        System.out.println("Максимальное значение: "
                + list.get(list.size() - 1));
        System.out.println("Значение в середине: "
                + list.get(list.size() / 2));
    }
}
