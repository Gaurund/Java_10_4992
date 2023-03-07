public class HomeWork02 {

    public static void main(String[] args) {
        String string01 = "Some intricate chunk of a text.";
        String string02 = "chunk of a text";
        HomeWork02.searchStrInStr(string01, string02);

        String stringFro = "Text to reverse";
        String stringBack = "esrever ot txeT";
        HomeWork02.checkReversedStrs(stringFro, stringBack);

        int num01 = 3;
        int num02 = 56;
        String stringPlus = HomeWork02.doSomeMath(num01, num02, " + ");
        String stringMinus = HomeWork02.doSomeMath(num01, num02, " - ");
        String stringMultiply = HomeWork02.doSomeMath(num01, num02, " * ");
        System.out.println(stringPlus);
        System.out.println(stringMinus);
        System.out.println(stringMultiply);

        stringPlus = changeSym2WordV1(stringPlus);
        System.out.println(stringPlus);

        stringMinus = changeSym2WordV2(stringMinus);
        System.out.println(stringMinus);

    }

    private static void searchStrInStr(String firstStr, String secondStr) {
        if (firstStr.contains(secondStr)) {
            System.out.println("Yes, the second string is in the first one");
        } else if (secondStr.contains(firstStr)) {
            System.out.println("Yes, the first string is in the second one");
        } else {
            System.out.println("Nope! They are not related.");
        }
    }

    private static void checkReversedStrs(String firstStr, String secondStr) {
        String tempStr = new StringBuilder(secondStr).reverse().toString();
        if (firstStr.equals(tempStr)) {
            System.out.println("Yes, it seems to me like one of them is a reversed another!");
        } else {
            System.out.println("Nope! It's not a palindrome.");
        }

    }

    private static String doSomeMath(int num01, int num02, String op) {
        StringBuilder str = new StringBuilder();
        int total = 0;
        switch (op) {
            case (" + "):
                total = num01 + num02;
                break;
            case (" - "):
                total = num01 - num02;
                break;
            case (" * "):
                total = num01 * num02;
                break;
        }
        return str.append(num01).append(op).append(num02).append(" = ").append(total).toString();
    }

    private static String changeSym2WordV1(String str){
        StringBuilder builder = new StringBuilder(str);
        int pos = builder.indexOf("=");
        builder.deleteCharAt(pos).insert(pos,"равно");
        return builder.toString();
    }

    private static String changeSym2WordV2(String str){
        StringBuilder builder = new StringBuilder(str);
        int pos = builder.indexOf("=");
        builder.replace(pos,pos+1,"равно");
        return builder.toString();
    }

}
