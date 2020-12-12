/**
class that manages Classical song objects.
*@author Sahit Kavukuntla
*@version 1.0
*/
public class ClassicalSong implements Playable {
    private String name;
    private String artist;
    private int length;

    /**
    constructor for ClassicalSong class, creates ClassicalSong objects.
    *@param inName name of song
    *@param inArtist song's artist
    *@param inLength song's length in seconds
    */
    public ClassicalSong(String inName, String inArtist, int inLength) {
        this.name = inName;
        this.artist = inArtist;
        this.length = inLength;
    }

    @Override
    public void play() {
        for (int i = 0; i < this.length; i++) {
            System.out.print("weewoo ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return this.name + " by " + this.artist + " pub";
    }
}