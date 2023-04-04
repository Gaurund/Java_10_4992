package units;

public class State {
    private int stateID;
    private static final String[] states = new String[] {"† мёртв","ждёт","занят","скрыт","под магической защитой"};
    public State() {
        this.stateID = 1;
    }

    public int getStateID(){
        return stateID;
    }
    public String getStateName(){
        return states[stateID];
    }

    public void changeState(int newValue){
        stateID = newValue;
    }
}
