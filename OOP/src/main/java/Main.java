import units.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        heroes.add(new Archer("Мильва", 1, 6, 1));
        heroes.add(new Crossbowman("Виго", 10, 3, 2));
        heroes.add(new Monk("Риен", 1, 8, 3));
        heroes.add(new Mage("Вильгефорц", 10, 5,4));
        heroes.add(new Rogue("Геральт", 1,5,5));
        heroes.add(new Lancer("Кахир", 10,7,6));
        heroes.add(new Peasant("Лютик", 1,7,7));
        heroes.add(new Peasant("Дэни", 10,2,8));

        heroes.forEach(e -> System.out.println(e));
    }
}
