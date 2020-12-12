/**
class that represents a playlist of songs.
*@author Sahit Kavukuntla
*@version 1.0
*/
public class PlayList {
    private Playable[] songs;
    private String name;
    private int currentlyPlaying;
    private User owner;

    /**
    constructor for PlayList class, creates PlayList objects.
    *@param inSongs array of Playable objects
    *@param inName playlist's name
    *@param inOwner song's owner
    */
    public PlayList(Playable[] inSongs, String inName, User inOwner) {
        this.songs = inSongs;
        this.name = inName;
        this.owner = inOwner;
        this.currentlyPlaying = -1;
    }

    @Override
    public String toString() {
        if (this.currentlyPlaying == -1) {
            return this.name + " owned by " + this.owner.toString() + ", currently playing nothing";
        }
        return this.name + " owned by " + this.owner.toString() + ", currently playing " + songs[currentlyPlaying];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlayList)) {
            return false;
        }
        PlayList l = (PlayList) obj;
        return this.name.equals(l.name) && this.owner.equals(l.owner);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.owner.hashCode();
    }

    /**
    method that starts playing songs from the playlist.
    */
    public void startPlaying() {
        int temp = currentlyPlaying;
        if (temp < 0 || temp > songs.length - 1) {
            temp = 0;
        }
        for (int i = temp; i < songs.length; i++) {
            songs[i].play();
        }
        this.currentlyPlaying = -1;
    }

    /**
    setter for songs variable.
    *@param inSongs array of songs
    */
    public void setSongs(Playable[] inSongs) {
        this.songs = inSongs;
    }

    /**
    getter for songs variable.
    *@return songs array
    */
    public Playable[] getSongs() {
        return this.songs;
    }
}