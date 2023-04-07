import java.util.Collections;
import units.*;
public class View {
    private static int turn = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (BaseHero e: Main.armies) {
            if (e.getPosition().getX() == x && e.getPosition().getY() == y
            ){
                if (e.isDead(e)) {
                    out = "|" + (AnsiColors.ANSI_RED + e.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Main.blacks.contains(e)) out = "|" + (AnsiColors.ANSI_GREEN + e.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (Main.whites.contains(e)) out = "|" + (AnsiColors.ANSI_BLUE + e.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (turn == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First turn" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Turn:" + turn + AnsiColors.ANSI_RESET);
        }
        turn++;
        Main.armies.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Blue side (Белые)");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0]-17));
        System.out.println(":\tGreen side (Чёрные)");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Main.whites.get(0));
        tabSetter(Main.whites.get(0).toString().length(), l[0]);
        System.out.println(Main.blacks.get(0));
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.whites.get(i-1));
            tabSetter(Main.whites.get(i-1).toString().length(), l[0]);
            System.out.println(Main.blacks.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(Main.whites.get(9));
        tabSetter(Main.whites.get(9).toString().length(), l[0]);
        System.out.println(Main.blacks.get(9));
        System.out.println(bottom10);
    }
}