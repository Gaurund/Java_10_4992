import java.util.Arrays;
import java.util.List;

public class S3_1 {
    public static void main(String[] args) {
        String day = "13";
        String month = "3";
        String year = "2013";
        String[] date = {day, month, year};
        List<String> d = Arrays.asList(date);
        System.out.println(d);
        date[1] = "4";
        System.out.println(d);


    }
}
