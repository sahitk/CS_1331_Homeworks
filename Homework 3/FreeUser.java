/**
class that represents free users.
*@author Sahit Kavukuntla
*@version 1.0
*/
public class FreeUser extends User {
    /**
    constructor for FreeUser class, creates FreeUser objects.
    *@param inName name of free user
    */
    public FreeUser(String inName) {
        super(inName);
    }

    @Override
    public void giveRecommendation(PlayList jamsesh) {
        if (jamsesh.getSongs().length == 0) {
            System.out.println("The playlist is empty");
        } else {
            System.out.print("I recommend the " + jamsesh.getSongs()[0]);
        }
    }

}