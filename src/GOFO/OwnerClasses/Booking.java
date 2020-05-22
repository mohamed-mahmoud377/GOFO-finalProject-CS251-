package GOFO.OwnerClasses;

/**@author abdralham fesl
 * @version v1.0
 *
 *
 */
public class Booking {
    static int NumID;
    String ID;
    int startingDate;
    int endingDate;
    int duration;
    String playerID;
    String ownerName;
    String ownerID;
    String playgroundName;
    String playGroundID;

    public Booking() {
        this(-1,-1,-1,"none","none","none","none","none");
        ID = "bk"+ NumID++;


    }

    public Booking(int startingDate, int endingDate, int duration, String playerID, String ownerName, String ownerID, String playgroundName, String playGroundID) {
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.duration = duration;
        this.playerID = playerID;
        this.ownerName = ownerName;
        this.ownerID = ownerID;
        this.playgroundName = playgroundName;
        this.playGroundID = playGroundID;
        ID = "bk"+ NumID++;

    }

    public Booking(int startingDate, int endingDate, int duration, String playerID, String ownerID) {
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.duration = duration;
        this.playerID = playerID;
        this.ownerID = ownerID;
        ID = "bk"+ NumID++;

    }


    public int getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(int startingDate) {
        this.startingDate = startingDate;
    }

    public int getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(int endingDate) {
        this.endingDate = endingDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }
}
