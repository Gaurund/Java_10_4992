package units;

public class Mana {
    private final int maxMana;
    private int mana;

    private boolean depleted;
    public Mana(int mana) {
        this.mana = mana;
        this.maxMana = mana;
        this.depleted = false;
    }

    public int getMana(){
        return this.mana;
    }

    public void payMana(int cost){
        this.mana = this.mana - cost;
        if(this.mana <= 0) {
            this.mana = 0;
            this.depleted = true;
        }
    }

    public void restoreMana(int newMana){
        this.mana = this.mana + newMana;
        this.depleted = false;
        if(this.mana >= this.maxMana){
            this.mana = this.maxMana;
        }

    }
}
