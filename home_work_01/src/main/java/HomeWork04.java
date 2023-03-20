import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class HomeWork04 {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList<String[]> namesList = new LinkedList<>();
    static LinkedList<Integer> yearList = new LinkedList<>();
    static LinkedList<Integer> genderList = new LinkedList<>();

    static String[] male = {"м", "мужской", "муж", "мужчина",
            "мальчик", "молодой человек", "юноша"};

    static String[] female = {"ж", "женский", "жен", "женщина",
            "девушка", "девочка", "д", "богиня"};

    static String[] gender = {"с полом не определились", "мужской", "женский"};

    static String[] locale = {"Введите фамилию:", "Введите имя:", "Введите отчество:",
            "Введите год рождения:", "Введите пол:"};

    public static void main(String[] args) {
        String command;
        do {
            System.out.println("Введите:\n\"1\" для ввода новой записи\n" +
                    "\"2\" для вывода списка контактов.\n" +
                    "\"3\" для вывода списка контактов по возрасту.\n" +
                    "\"4\" для вывода списка контактов по полу.\n" +
                    "\"5\" для вывода списка контактов по возрасту и по полу.\n" +
                    "Введите \"Q\" для завершения ввода данных\n");
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    newRecord();
                    break;
                case "2":
                    printContacts();
                    break;
                case "3":
                    sortByYear();
                    break;
                case "4":
                    sortByGender();
                    break;
                case "5":
                    sortByYearAndGender();
                    break;
            }

        } while (!command.equalsIgnoreCase("q"));
    }

    private static String getString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    private static String[] getNames() {
        String[] names = new String[3];
        for (int i = 0; i < 3; i++) {
            names[i] = getString(locale[i]);
        }
        return names;
    }

    private static Integer getYear() {
        return Integer.parseInt(getString(locale[3]));
    }

    private static Integer getGender() {
        String gender = getString(locale[4]);
        for (String m : male) {
            if (gender.toLowerCase().equals(m)) return 1;
        }
        for (String w : female) {
            if (gender.toLowerCase().equals(w)) return 2;
        }
        return 0;
    }

    private static void newRecord() {
        namesList.add(getNames());
        yearList.add(getYear());
        genderList.add(getGender());
    }

    private static void printContact(int i) {
        System.out.println(
                namesList.get(i)[0] + " " +
                namesList.get(i)[1].toUpperCase().charAt(0) + "." +
                namesList.get(i)[2].toUpperCase().charAt(0) + ". " +
                yearList.get(i) + " " +
                gender[genderList.get(i)]
        );
    }

    private static void printContacts() {
        System.out.println("Список контактов без сортировки:\n");
        for (int i = 0; i < namesList.size(); i++) {
            printContact(i);
        }
        System.out.println();
    }

    private static void printContactsSorted(int[] sorted) {
        for (int j : sorted) {
            printContact(j);
        }
        System.out.println();
    }

    private static int[] arrayFilledStraight(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static void sortByYear() {
        int[] sorted = arrayFilledStraight(yearList.size());
        sortInt(sorted, yearList);
        System.out.println("Список контактов по возрасту:\n");
        printContactsSorted(sorted);
    }

    private static void sortByGender() {
        int[] sorted = arrayFilledStraight(yearList.size());
        sortInt(sorted, genderList);
        System.out.println("Список контактов по половой принадлежности:\n");
        printContactsSorted(sorted);
    }

    private static void sortByYearAndGender() {
        int[] sorted = arrayFilledStraight(yearList.size());
        for (LinkedList<Integer> integers : Arrays.asList(yearList, genderList)) {
            sortInt(sorted, integers);
        }
        System.out.println("Список контактов сортированный по возрасту и полу:\n");
        printContactsSorted(sorted);
    }

    private static void sortInt(int[] sorted, LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
    }
}
