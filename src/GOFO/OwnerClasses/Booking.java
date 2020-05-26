package GOFO.OwnerClasses;

/**@author abdralham fesl
 * @version v1.0
 *
 *
 */
public class Booking {
   private static int NumID;
    private String ID;
    private int startingDate;
    private  int endingDate;
    private int duration;
    private String playerID;
    private String ownerName;
    private String ownerID;
    private String playgroundName;
    private String playGroundID;
    public Booking(int startingDate, int endingDate,String ID , String playerID) {
        this(startingDate,endingDate,-1,playerID,"none","none","none","none");
        this.ID = ID;


    }
    public Booking(int startingDate, int endingDate) {
        this(startingDate,endingDate,-1,"none","none","none","none","none");
        ID = "bk"+ NumID++;

    }

    public Booking() {
        this(-1,-1,-1,"none","none","none","none","none");
        ID = "bk"+ NumID++;
        duration= endingDate- startingDate;


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

    public void setDuration() {
        duration = endingDate-startingDate;
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

    public static int getNumID() {
        return NumID;
    }

    public static void setNumID(int numID) {
        NumID = numID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPlaygroundName() {
        return playgroundName;
    }

    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    public String getPlayGroundID() {
        return playGroundID;
    }

    public void setPlayGroundID(String playGroundID) {
        this.playGroundID = playGroundID;
    }

    public  void displayForGround(){
        System.out.println("ID " +ID +" staring time : "+ startingDate +"ending time : " +endingDate);

    }
    public  void displayForPlayer(){
        System.out.println("booking ID : "+ ID);
        System.out.println("PlayGround name is " + playgroundName +" ID :"+playGroundID +"your ID : " +playerID);
        System.out.println("The owner of the Playground ID :" + ownerID);
        System.out.println("booking stars at : " + startingDate);
        System.out.println("booking ends at : "+ endingDate);
        System.out.println("Duration :" +duration);


    }
}
