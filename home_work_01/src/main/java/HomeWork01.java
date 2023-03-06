import java.util.Random;

public class HomeWork01 {
    public static void main(String[] args) {
        int limit = 2000;
        int i = getRandomInt(limit);
        int n = getMostSignificantBit(i);
        int[] m1 = createEvenIntArray(i, n);
        int[] m2 = createOddIntArray(i, n);
//        output(i, n, m1, m2);
    }

    private static int getRandomInt(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    private static int getMostSignificantBit(int i) {
        return Integer.toBinaryString(i).length();
    }

    private static int[] createEvenIntArray(int i, int n) {
        final int shortMaxValue = Short.MAX_VALUE;
        int range = shortMaxValue - i;
        int even = range / n;
        int[] array = new int[even];
        int start = i / n * n + n;
        for (int j = start, k = 0; j <= shortMaxValue; j += n, k++) {
            array[k] = j;
        }
        return array;
    }

    private static int[] createOddIntArray(int i, int n) {
        final int shortMinValue = Short.MIN_VALUE;
        int size = i - shortMinValue;
        int[] array = new int[size];
        int k = 0;
        for (int j = shortMinValue; j <= i; j++) {
            if (j % n != 0) {
                array[k] = j;
                k++;
            }
        }
        array = shortenArray(array, k);
        return array;
    }

    private static int[] shortenArray(int[] array, int size) {
        int[] temp = new int[size];
        System.arraycopy(array, 0, temp, 0, size);
        return temp;
    }

    private static void output(int i, int n, int[] m1, int[] m2) {
        System.out.printf("Случайное число i = %d%n", i);
        System.out.printf("Его номер старшего значащего бита n = %d%n", n);
        System.out.println("Первый массив: ");
        for (int item : m1) {
            System.out.println(item);
        }
        System.out.println("Второй массив: ");
        for (int item : m2) {
            System.out.println(item);
        }
    }

}
