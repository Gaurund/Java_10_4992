import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Contacts {
    static LinkedList<ArrayList<String>> contacts = new LinkedList<>();
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        getData();
        printContacts();
        Comparator<ArrayList> compareAge = new Comparator<ArrayList>() {
            @Override
            public int compare(ArrayList t1, ArrayList t2) {
                int intT1 = Integer.parseInt(t1.get(3).toString());
                int intT2 = Integer.parseInt(t2.get(3).toString());
                if (intT1>intT2) return 1;
                else if (intT1<intT2) return -1;
                return 0;
            }
        };
        System.out.println(("\nСортировка по году рождения: "));
        contacts.sort(compareAge);
        printContacts();
        Comparator<ArrayList> compareGender = new Comparator<ArrayList>() {
            @Override
            public int compare(ArrayList t1, ArrayList t2) {
                if (t1.get(4).equals("М") && t2.get(4).equals("Ж")) return 1;
                else if (t1.get(4).equals("Ж") && t2.get(4).equals("М")) return -1;
                return 0;
            }
        };
        System.out.println(("\nСортировка по полу: "));
        contacts.sort(compareGender);
        printContacts();


    }
    private static void printContacts(){
        for (ArrayList<String> record:contacts) {
            System.out.print(record.get(0)+" ");
            System.out.print(record.get(1).toUpperCase().charAt(0)+".");
            System.out.print(record.get(2).toUpperCase().charAt(0)+". ");
            System.out.print(record.get(3)+" года рождения. Пол: ");
            System.out.print(record.get(4)+"\n");
        }
    }
    private static void getData(){
        String command;
        do {
            System.out.println("Введите \"1\" для ввода новой записи\nВведите \"2\" для завершения ввода данных\n");
            command = myScanner.nextLine();
            if (command.equals("1")) {
                contacts.add(getRecord());
            }
        } while (!command.equals("2"));
    }
    private static ArrayList<String> getRecord() {
        ArrayList<String> newRecord = new ArrayList<>();
        System.out.println("Введите фамилию:");
        String lastName = myScanner.nextLine();
        newRecord.add(lastName);
        System.out.println("Введите имя:");
        String firstName = myScanner.nextLine();
        newRecord.add(firstName);
        System.out.println("Введите отчество:");
        String middleName = myScanner.nextLine();
        newRecord.add(middleName);
        System.out.println("Год рождения:");
        String age = myScanner.nextLine();
        newRecord.add(age);
        System.out.println("Введите пол:");
        String gender = myScanner.nextLine();
        newRecord.add(gender);

        return newRecord;
    }
}
