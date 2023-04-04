package units;

import java.util.HashMap;

public class Side {
    protected int sideID;
    private static final String[] sides = new String[] {"Белый","Чёрный"};
    public Side(int sideID){
        this.sideID=sideID;
    }

    public int getSideID(){
        return sideID;
    }
    public String getSideName(){
        return sides[sideID];
    }
}
