import units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<BaseHero> whites = new ArrayList<>();
        ArrayList<BaseHero> blacks = new ArrayList<>();
        FillHeroes(whites, 1);
        FillHeroes(blacks, 10);

        System.out.println("Команда белых:");
        whites.forEach(System.out::println);

        System.out.println("\nКоманда черных:");
        blacks.forEach(System.out::println);

        System.out.println("\nДемонстрация работы getInfo");
        blacks.forEach(e -> System.out.println(e.name + " — " + e.getInfo()));


//        SpellBook spell = SpellBook.values()[new Random().nextInt(Names.values().length)];
//        if (spell.getPower() == Float.NaN) {
//
//        }

    }

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
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
                    list.add(new Peasant(getName(), shift, y));
            }
        }
    }
}
