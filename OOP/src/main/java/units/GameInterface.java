package units;

import units.BaseHero;
import units.Position;
import units.State;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> enemyList, ArrayList<BaseHero> teamList);

    void upkeep();
    int getSideID();
    State getState();
    Position getPosition();
    String getInfo();

}
