import units.*;
import units.NameGenerator.firstSyl;
import units.NameGenerator.lastSyl;
import units.NameGenerator.midSyl;

import java.util.*;

public class Main {

    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        Score score = new Score();
        String[] winner = new String[] {"Белых!", "Чёрных!"};

        ArrayList<BaseHero> whites = new ArrayList<>();
        ArrayList<BaseHero> blacks = new ArrayList<>();
        FillHeroes(whites, 1);
        FillHeroes(blacks, 10);
        ArrayList<BaseHero> armies = new ArrayList<>();
        armies.addAll(whites);
        armies.addAll(blacks);

        System.out.println("\nКоманда белых:");
        whites.forEach(System.out::println);

        System.out.println("\nКоманда черных:");
        blacks.forEach(System.out::println);
        armies.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });

        do {

            System.out.println("\nВсе команды:");
            armies.forEach(System.out::println);

            System.out.println("\nБой начался:");
            for (BaseHero e : armies) {
                System.out.println(e);
                e.step(armies, score);
            }

            if(score.checkScore()!= null) break;

            armies.forEach(BaseHero::upkeep);

            System.out.println(score);
        }
        while (Objects.equals(myScanner.nextLine(), ""));

        System.out.println("\n\n================================================"+"\nИгра закончена. Победила команда " + winner[score.checkScore()]);
    }

    private static String getName() {
        return nameGen();//Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    private static String nameGen() {
        return firstSyl.values()[new Random().nextInt(firstSyl.values().length)].toString() +
                midSyl.values()[new Random().nextInt(midSyl.values().length)].toString() +
                lastSyl.values()[new Random().nextInt(lastSyl.values().length)].toString();
    }

    private static void FillHeroes(ArrayList<BaseHero> list, int shift) {
        Random rnd = new Random();
        for (int y = 1; y < 11; y++) {
            switch (rnd.nextInt(4) + shift) {
                case 1:
                    list.add(new Archer(getName(), shift, y));
                    break;
                case 2:
                    list.add(new Monk(getName(), shift, y));
                    break;
                case 3:
                    list.add(new Rogue(getName(), shift, y));
                    break;
                case 4:
                    list.add(new Peasant(getName(), 0, shift, y));
                    break;
                case 10:
                    list.add(new Crossbowman(getName(), shift, y));
                    break;
                case 11:
                    list.add(new Mage(getName(), shift, y));
                    break;
                case 12:
                    list.add(new Lancer(getName(), shift, y));
                    break;
                default:
                    list.add(new Peasant(getName(), 1, shift, y));
            }
        }
    }
}
