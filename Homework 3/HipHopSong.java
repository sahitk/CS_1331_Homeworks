/**
class that manages Hip Hop song objects.
*@author Sahit Kavukuntla
*@version 1.0
*/
public class HipHopSong implements Playable {
    private String name;
    private String artist;
    private String producer;

    /**
    constructor for HipHopSong class, creates HipHopSong objects.
    *@param inName name of song
    *@param inArtist song's artist
    *@param inProducer song's producer
    */
    public HipHopSong(String inName, String inArtist, String inProducer) {
        this.name = inName;
        this.artist = inArtist;
        this.producer = inProducer;
    }
    @Override
    public void play() {
        System.out.printf("%s on the track! Twitter fingers turn to coding fingers%n", this.producer);
    }
    @Override
    public String toString() {
        return this.name + " by " + this.artist + " - woo!";
    }
}