/**
*class creates and manages ChargedSuperheroes, which are instances of the Superhero class.
*@author Sahit Kavukuntla
*@version 1.0
*/
public class ChargedSuperhero extends Superhero {
    private boolean charged;
/**
*class contructor.
*@param inName the name of the ChargedSuperhero
*@param inHealth health of ChargedSuperhero
*@param inDamage damage dealt by ChargedSuperhero
*@param inCharged whether or not the ChargedSuperhero is charged
*/
    public ChargedSuperhero(String inName, int inHealth, int inDamage, boolean inCharged) {
        super(inName, inHealth, inDamage);
        charged = inCharged;
    }
/**
*no args constructor.
*/
    public ChargedSuperhero() {
        this("Black Panther", 30, 10, false);
    }

/**
*getter for ChargedSuperhero charged status.
*@return is or is not charged
*/
    public boolean getCharged() {
        return this.charged;
    }
/**
*setter for ChargedSuperhero charged status.
*@param inCharged whether or not the ChargedSuperhero is charged
*/
    public void setCharged(boolean inCharged) {
        this.charged = inCharged;
    }

/**
*performs an attack on another superhero.
*if the attacking ChargedSuperhero is charged it deals double damage
*@param other the superhero that is being attacked
*/
    public void attack(Superhero other) {
        if (this.charged) {
            super.attack(other);
            super.attack(other);
        } else {
            super.attack(other);
        }
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && (this.charged == ((ChargedSuperhero) obj).charged);
    }
    @Override
    public String toString() {
        return super.toString() + "\nSuit Charged: " + this.charged;
    }
}