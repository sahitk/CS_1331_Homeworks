/**
*class creates and manages FlyingSuperheroes, which are instances of the Superhero class.
*@author Sahit Kavukuntla
*@version 1.0
*/
public class FlyingSuperhero extends Superhero {
    private boolean flying;
/**
*class contructor.
*@param inName the name of the FlyingSuperhero
*@param inHealth health of FlyingSuperhero
*@param inDamage damage dealt by FlyingSuperhero
*@param inFlying whether or not the FlyingSuperhero is flying
*/
    public FlyingSuperhero(String inName, int inHealth, int inDamage, boolean inFlying) {
        super(inName, inHealth, inDamage);
        this.flying = inFlying;
    }
    /**
*no args constructor.
*/
    public FlyingSuperhero() {
        this("Captain Marvel", 40, 7, false);
    }
/**
*performs an attack on another superhero.
*if the attacking FlyingSuperhero is flying it has a 50% chance of dealing triple damage
*@param other the superhero that is being attacked
*/
    public void attack(Superhero other) {
        double chance = Math.random();
        boolean tripled = chance >= 0.5;
        if (this.flying && tripled) {
            super.attack(other);
            super.attack(other);
            super.attack(other);
            return;
        }
        super.attack(other);
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && (this.flying == ((FlyingSuperhero) obj).flying);
    }
    @Override
    public String toString() {
        return super.toString() + "\nFlying: " + this.flying;
    }
}
