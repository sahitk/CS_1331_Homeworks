/**
abstract class that represents users and is used as the foundation for types of users.
*@author Sahit Kavukuntla
*@version 1.0
*/
public abstract class User {
    private String name;

    /**
    constructor for User class, creates User objects.
    *@param inName name of user
    */
    public User(String inName) {
        this.name = inName;
    }

    /**
    placeholder for a method for a type of user.
    *@param jamsesh a playlist provided by the user
    */
    public abstract void giveRecommendation(PlayList jamsesh);

    /**
    setter for user's name.
    *@param inName the desired name for the user
    */
    public void setName(String inName) {
        this.name = inName;
    }

    /**
    getter for user's name.
    *@return name of user
    */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User u = (User) obj;
        return this.name.equals(u.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}