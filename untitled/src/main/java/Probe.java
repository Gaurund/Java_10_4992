import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Probe {
    public static void main(String[] args) {

        System.out.println(Kata.sortDesc(45126793));

    }
}
class Kata{


        public static int sortDesc(final int num) {
            Integer number = num;
            Integer result = 0;
            ArrayList<Integer> list = new ArrayList<>();

                while (number != 0) {
                    list.add(number % 10);
                    number = number / 10;
                }
            if (list.size()>0){
                list.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                for (int i = list.size() - 1; i > 0; i--) {
                    result = result + list.get(i) * (int) Math.pow(10, i);
                }
                result = result + list.get(0);
            }
            return result;
        }

    public static String binaryAddition(int a, int b){
        String binary = "";
        int c = a + b;
        while (c != 0){
            binary = (c % 2) + binary;
            c = c / 2;
        }

        return binary;
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int result = 0;
        int j = 0;
        for (int i = binary.size()-1; i >= 0 ; i--) {
            result = result + (int) Math.pow(2,j)*binary.get(i);
            j++;
        }
        return result;
    }
}

