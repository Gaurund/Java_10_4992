package units;

public class Health {

    private float health;
    private final float maxHealth;


    public Health(float health) {
        this.health = health;
        this.maxHealth = health;
    }

    public boolean isHurt(){
        return health != maxHealth;
    }

    public void heal(float healing){
        this.health = this.health + healing;
        if (this.health > this.maxHealth) this.health = this.maxHealth;
    }

    public float getHealth(){
        return this.health;
    }

    public void getDamage(float damage){
        this.health = this.health - damage;
    }
}
