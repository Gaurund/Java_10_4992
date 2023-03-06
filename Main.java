import java.util.Random;

public class Main {

    static int i = 1; //32bit
    static long l = 6; //64bit
    static byte b; //8bit
    short sh; //16bit
    float f; //32bit floating poin
    double d; //64bit floating poin
    static boolean aBoolean;
    char aChar = 65; //16бит без знака
    String string = "Привет Мир!";
    static String tmpS = new String("Привет Мир!");

    static int[] ints = new int[10];

    public static void main(String[] args) {

        ints[3] = 10;
        int[] tmp = new int[ints.length * 2 + 1];

        Random random = new Random();

        for (int j=0 ; j<ints.length ; j++) {
            tmp[j] = ints[j] + random.nextInt(100);
        }
        tmp[15] = 5;
        ints = tmp;

        for (int i: ints) {
            System.out.println(i);
        }


        if (aBoolean) {
            getInt(String.valueOf(12));
        } else if ( l > i) {
            getInt(String.valueOf(13));
        } else {
            getInt(String.valueOf(14));
        }

        System.out.println(Integer.toBinaryString(158));
        System.out.println(
                Integer.toBinaryString(158).length()
        );

    }

    static int getInt(String strToInt){
        int i = 0;
        Main.l = i;
        return Integer.parseInt(strToInt);
    }

    static void print(String str){
        System.out.println(str);
    }
}