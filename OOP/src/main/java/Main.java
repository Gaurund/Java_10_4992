import units.*;
import units.NameGenerator.firstSyl;
import units.NameGenerator.lastSyl;
import units.NameGenerator.midSyl;

import java.util.*;

public class Main {

    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

         ArrayList<BaseHero> whites = new ArrayList<>();
         ArrayList<BaseHero> blacks = new ArrayList<>();
         ArrayList<BaseHero> armies = new ArrayList<>();

        createArmies(whites,blacks,armies);
//        printArmies(whites,blacks);
        sortArmies(armies);
        game(whites,blacks,armies);

    }

    private static void createArmies(ArrayList<BaseHero> whites,ArrayList<BaseHero> blacks,ArrayList<BaseHero> armies) {
        fillArmy(whites, 1);
        fillArmy(blacks, 10);
        armies.addAll(whites);
        armies.addAll(blacks);
    }

    private static void printArmies(ArrayList<BaseHero> whites,ArrayList<BaseHero> blacks) { // Избыточный метод. Планируется к удалению.
        System.out.println("\nКоманда синих:");
        whites.forEach(System.out::println);

        System.out.println("\nКоманда зелёных:");
        blacks.forEach(System.out::println);
    }

    private static void game(ArrayList<BaseHero> whites,ArrayList<BaseHero> blacks, ArrayList<BaseHero> armies) {
        Score score = new Score();
        String[] winner = new String[]{"Синих!", "Зелёных!"};
        do {
            View.view(whites,blacks,armies);
            for (BaseHero e : armies) {
                e.step(armies, score);
            }
            if (score.checkScore() != null) break;
            armies.forEach(BaseHero::upkeep);
            System.out.println(score);
        }
        while (Objects.equals(myScanner.nextLine(), ""));
        View.view(whites,blacks,armies);
        System.out.println("\n\n================================================" + "\n\nИгра закончена.");
        if (score.checkScore() == 3){
            System.out.println("Победила дружба!");
        } else {
            System.out.println("Победила команда " + winner[score.checkScore()]);
        }
    }

    private static void sortArmies(ArrayList<BaseHero> armies) {
        armies.sort(Comparator.comparingInt(BaseHero::getPriority));
    }

    private static String getName() {
        return firstSyl.values()[new Random().nextInt(firstSyl.values().length)].toString() +
                midSyl.values()[new Random().nextInt(midSyl.values().length)].toString() +
                lastSyl.values()[new Random().nextInt(lastSyl.values().length)].toString();
    }

    private static void fillArmy(ArrayList<BaseHero> list, int shift) {
        Random rnd = new Random();
        for (int x = 1; x < 11; x++) {
            switch (rnd.nextInt(4) + shift) {
                case 1:
                    list.add(new Archer(getName(), x, shift));
                    break;
                case 2:
                    list.add(new Monk(getName(), x, shift));
                    break;
                case 3:
                    list.add(new Rogue(getName(), x, shift));
                    break;
                case 4:
                    list.add(new Peasant(getName(), 0, x, shift));
                    break;
                case 10:
                    list.add(new Crossbowman(getName(), x, shift));
                    break;
                case 11:
                    list.add(new Wizard(getName(), x, shift));
                    break;
                case 12:
                    list.add(new Lancer(getName(), x, shift));
                    break;
                default:
                    list.add(new Peasant(getName(), 1, x, shift));
            }
        }
    }
}
