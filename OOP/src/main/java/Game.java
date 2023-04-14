

import units.*;
import java.util.ArrayList;

public class Game {
    private final Score score;
    private final Army army;
    public Game() {
        this.score = new Score();
        this.army = new Army();
    }

    public ArrayList<BaseHero> whites() {
        return  army.whites();
    }

    public ArrayList<BaseHero> blacks() {
        return army.blacks();
    }

    public ArrayList<BaseHero> all() {
        return army.all();
    }

    public Integer checkScore(){
        return score.checkScore();
    }
    public void turn() {
        for (BaseHero e : army.all()) {
            e.step(army.all(), score);
        }
    }

    public void upkeep() {
        for (BaseHero e : army.all()) {
            e.upkeep();
        }
    }

    public String getScore(){
        return score.toString();
    }
}
