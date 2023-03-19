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
        System.out.print(
                namesList.get(i)[0] + " " +
                        namesList.get(i)[1].toUpperCase().charAt(0) + "." +
                        namesList.get(i)[2].toUpperCase().charAt(0) + ". " +
                        yearList.get(i) + " " +
                        gender[genderList.get(i)] + "\n"
        );
    }

    private static void printContacts() {
        for (int i = 0; i < namesList.size(); i++) {
            printContact(i);
        }
        System.out.println();
    }

    private static void sortByYear() {
        int[] sorted = new int[yearList.size()];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }
        for (int i = 0; i < yearList.size() - 1; i++) {
            for (int j = 0; j < yearList.size() - i - 1; j++) {
                if (yearList.get(j) > yearList.get(j + 1)) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            printContact(sorted[i]);
        }
        System.out.println();
    }

    private static void sortByGender() {
        int[] sorted = new int[genderList.size()];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }
        for (int i = 0; i < genderList.size() - 1; i++) {
            for (int j = 0; j < genderList.size() - i - 1; j++) {
                if (genderList.get(j) > genderList.get(j + 1)) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            printContact(sorted[i]);
        }
        System.out.println();
    }

    private static void sortByYearAndGender() {
        int[] sorted = new int[genderList.size()];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }
        for (int i = 0; i < yearList.size() - 1; i++) {
            for (int j = 0; j < yearList.size() - i - 1; j++) {
                if (yearList.get(j) > yearList.get(j + 1)) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < genderList.size() - 1; i++) {
            for (int j = 0; j < genderList.size() - i - 1; j++) {
                if (genderList.get(j) > genderList.get(j + 1)) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            printContact(sorted[i]);
        }
        System.out.println();
    }
}
