import java.util.StringTokenizer;

public class S2 {

    public static void main(String[] args) {

        String str = "";
        StringBuilder builder = new StringBuilder();

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            str += Character.getName(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("to String: " + (end - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            builder.append(Character.getName(i));
        }
        end = System.currentTimeMillis();
        System.out.println("to StringBuilder: " + (end - begin) );

        System.out.println(str.toLowerCase());
        System.out.println(str.length());
        System.out.println("_*".repeat(10));

        String a = "d";
        String f = "d";

        System.out.println(str.equals("N"));
        //if (str == "N")
        System.out.println(str.contains("N"));
        str = "Hello     World ! Привет Мир !";
        System.out.println(str.replace("l", "p"));
        System.out.println(str.replaceFirst("l", "p"));
        System.out.println(str.charAt(1));
        String[] strings = str.split(" ");
        builder.replace(0, 1, "F");
        builder.reverse();
        builder.insert(4, " inserted ");
        builder.deleteCharAt(6);
        builder.indexOf("Fd");
        str = new StringBuilder(str).reverse().toString();

    }
}