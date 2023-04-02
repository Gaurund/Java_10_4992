package units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> enemyList, ArrayList<BaseHero> teamList);

    Position getPosition();
    String getInfo();

}
