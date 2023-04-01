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

        blacks.get(0).setHealth(-1);
        System.out.println("\nБлижайший к персонажу противник: "+whites.get(0).nearestEnemy(blacks));


//        System.out.println("\nДемонстрация работы getInfo");
//        blacks.forEach(e -> System.out.println(e.name + " — " + e.getInfo()));


        SpellBook spell = SpellBook.values()[new Random().nextInt(SpellBook.values().length)];
        if (spell.getPower() == Float.NaN) {

        }

        BaseHero whiteArcher = new Archer("Белый",1,1);
        BaseHero blackXbowman = new Crossbowman("Чёрный", 5,2);
//        System.out.println(whiteArcher.nearestEnemy(blacks));
//        System.out.println(blackXbowman);

//        System.out.println("Работа position: ");
//        System.out.println(whiteArcher.name + " " + whiteArcher.getPosition().toString());
//        System.out.println(blackXbowman.name + " " + blackXbowman.getPosition().toString());
//        System.out.println(whiteArcher.getPosition().getDistance(blackXbowman.getPosition()));

    }

    private static String getName() {
        return nameGen();//Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public static String nameGen(){
        Random rnd = new Random();
        StringBuilder name = new StringBuilder();
        name.append(firstSyl.values()[new Random().nextInt(firstSyl.values().length)].toString());
        name.append(midSyl.values()[new Random().nextInt(midSyl.values().length)].toString());
        name.append(lastSyl.values()[new Random().nextInt(lastSyl.values().length)].toString());
        return name.toString();
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
