package units;

public class State {
    private static final String[] states = new String[]{"\u2670 мёртв", "ждёт", "занят", "скрыт", "под магической защитой"};
    private int stateID;

    public State() {
        this.stateID = 1;
    }

    public int getStateID() {
        return stateID;
    }

    public String getStateName() {
        return states[stateID];
    }

    private void setState(int state) {
        stateID = state;
    }
    public void setBusy(){
        setState(2);
    }

    public void setWaiting(){
        setState(1);
    }
    public void die(){
        setState(0);
    }

    public boolean isDead(BaseHero hero){
        return hero.getState().getStateID() == 0;
    }

    public boolean isBusy(BaseHero hero){
        return hero.getState().getStateID() == 2;
    }
    public boolean isWaiting(BaseHero hero){
        return hero.getState().getStateID() == 1;
    }

    public boolean isHidden(BaseHero hero){
        return hero.getState().getStateID() == 3;
    }

    public boolean isShielded(BaseHero hero){
        return hero.getState().getStateID() == 4;
    }
}
