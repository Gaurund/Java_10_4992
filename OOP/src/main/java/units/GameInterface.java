package units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> armies);

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
