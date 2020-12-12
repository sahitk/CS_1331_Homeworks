//I worked on the homework assignment alone, using only course materials.

/**
*Superhero class that manages superhero objects.
*@author Sahit Kavukuntla
*@version 1.0
*/

public class Superhero {

    private String name;
    private int health;
    private int damage;

/**
*contructor for the Superhero class.
*@param inName name of superhero
*@param inHealth health of superhero
*@param inDamage damage dealt by superhero
*/

    public Superhero(String inName, int inHealth, int inDamage) {
        this.name = inName;
        this.health = inHealth;
        this.damage = inDamage;
    }
/**
*getter for superhero name.
*@return name
*/
    public String getName() {
        return this.name;
    }
/**
*setter for superhero name.
*@param inName name that should be set for superhero
*/
    public void setName(String inName) {
        this.name = inName;
    }

/**
*getter for superhero health.
*@return health
*/
    public int getHealth() {
        return this.health;
    }
/**
*setter for superhero health.
*@param inHealth health that should be set for superhero
*/
    public void setHealth(int inHealth) {
        this.health = inHealth;
    }

/**
*getter for superhero damage.
*@return damage
*/
    public int getDamage() {
        return this.damage;
    }
/**
*setter for superhero damage.
*@param inDamage damage that should be set for superhero
*/
    public void setDamage(int inDamage) {
        this.damage = inDamage;
    }
/**
*performs an attack on another superhero.
*@param other the superhero that is being attacked
*/
    public void attack(Superhero other) {
        if (this.health > 0) {
            if (other.health < this.damage) {
                other.health = 0;
            } else {
                other.health -= this.damage;
            }
        }
    }
/**
*compares two superhero objects and determines if they are the same superhero or not.
*@param obj the object that the superhero is being compared to
*@return whether or not the superhero and the object are the same superhero
*/
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Superhero)) {
            return false;
        }
        Superhero s = (Superhero) obj;
        return this.name.equals(s.name)
            && this.health == s.health
            && this.damage == s.damage;
    }
/**
*provides a formatted string of superhero's information.
*@return string with labeled superhero info
*/
    public String toString() {
        return "SUPERHERO\nName: " + this.name
            + "\nHealth: " + this.health
            + "\nStrength: " + this.damage;
    }
}
