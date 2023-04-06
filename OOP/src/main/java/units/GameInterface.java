package units;

import java.util.ArrayList;

public interface GameInterface {
    boolean isDead(BaseHero hero);
    void step(ArrayList<BaseHero> armies, Score score);

    void upkeep();

    int getSide();

    State getState();

    Position getPosition();

    String getInfo();

    int getArrows();

    int getMaxArrows();

    void setArrows();

    void setPlusOneArrow();
}
