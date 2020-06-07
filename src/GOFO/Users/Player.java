package GOFO.Users ;

import GOFO.DataModel.DataSource;
import GOFO.OwnerClasses.Booking;
import GOFO.PlayerClasses.Invitation;
import GOFO.PlayerClasses.Team;
import GOFO.Registering.I_SignUp;
import GOFO.Registering.I_UdataInfo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;
/**
 *class that contain every thing about the Player and his bookings
 * @author mohamed mahomud

 */

public class Player extends User implements  I_SignUp , I_UdataInfo {
    private String myTeamID;
    private List<String> joinedTeamsIDs;
    private List <String> bookingsID;

    public List<String> getBookingsID() {
        return bookingsID;
    }

    public void setBookingsID(List<String> bookingsID) {
        this.bookingsID = bookingsID;
    }

    //constructors
    public Player(){
        super();
        type = "Player";
        joinedTeamsIDs = new ArrayList<String>();
        myTeamID="none";
        bookingsID= new ArrayList<String>();


    }

    public Player(String ID, String name, String email, String passWord) {
        super(ID, name, email, passWord);
        type = "Player";
        joinedTeamsIDs = new ArrayList<String>();
        myTeamID="none";
        bookingsID= new ArrayList<String>();



    }



// sgining up

    /**
     * this method is making sure that the name the user enters is vaild
     * is only valid is it is english char only
     * and return true when its right and false when the name is wrong
      @author mohamed mohmoud said
     * @param name the given name by the user
     * @return true if the name were valid
     */
    @Override
    public boolean signUp_name(String name) {
        name = name.trim();
        for(int i=0;i<name.length();i++){
            char a = name.charAt(i);
            if(!isLetter(a) &&!isWhitespace(a)){
                return false;
            }

        }
        this.name = name;
        return true;
    }

    /**
     *  it checks if the given ID were valid or not and if it is taken before or not
     * @author mohamed mahmoud
     * @param ID the given ID by the user
     * @return true if the ID is valid false if not

     *
     */
    @Override
    public boolean signUp_ID(String ID) {
        if( DataSource.getInstance().checkUserIDIfValid(ID)) {
            for (int i = 0; i < ID.length(); i++) {
                char a = ID.charAt(i);
                if (!isDefined(a) || isWhitespace(a)) {
                    return false;
                }
            }
        }else {
            return false;
        }
        this.ID = ID;
        return true;
    }

    /**
     * checks if the the email entered is valid or not from its string only
     * @param Email the email entered by the user
     * @return true if the email were valid
     */
    @Override
    public boolean signUp_Email(String Email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        this.Email = Email;
        return Email.matches(regex);


    }
    /**
     * checks if the password is valid or not it is valid if it has at least one capital alphabet and one number and
     * at least 8 char
     * @param password the password entered by the Owner
     * @return true if the password is valid false if not
     */
    @Override
    public boolean signUp_password(String password) {
        boolean num_check = false;
        boolean cap_check = false;
        if(password.length()<8)
            return false;
        for(int i=0 ;i<password.length();i++){
            if(isUpperCase(password.charAt(i)))
                cap_check = true;
            if(isDigit(password.charAt(i)))
                num_check=true;

        }
        this.passWord = password;
        return num_check && cap_check;
    }
    /**
     * creates a new account by adding it to dataSource class
     */
    @Override
    public void create_account() {
        DataSource.getInstance().addNewUser(this);
        DataSource.getInstance().addNewPlayer(this);

    }


    //getters

    public String getMyTeamID() {
        return myTeamID;
    }
    public List<String> getJoinedTeamsIDs() {
        return joinedTeamsIDs;
    }
    @Override
    public String getType() {
        return type;
    }
    public Team getMyTeam(){
        return  DataSource.getInstance().getTeamByPlayerID(ID);

    }


    //setters


    public void setMyTeamID(String myTeamID) {
        this.myTeamID = myTeamID;
    }



    public void setJoinedTeamsIDs(List<String> joinedTeamsIDs) {
        this.joinedTeamsIDs = joinedTeamsIDs;
    }






 //update
    @Override
    public boolean chanceName(String name) {
        return false;
    }

    @Override
    public boolean chancePassword(String password) {
        return false;
    }

    //adders

    /**
     * adds a brands new team to the dataSource and this team is the team that the player owns
     * @param team the new team
     */
    public void addMyTeam(Team team){
         myTeamID = team.getID();
        DataSource.getInstance().addNewTeam(team);

    }
    /**
     * adds a brands new team to the dataSource and this team is the team that the player joined
     * @param teamID the new team ID
     */
    public void addJoinedTeam(String teamID){
        joinedTeamsIDs.add(teamID);
    }

 // invitations

    /**
     * send a new invitation to the other players to join his team
     * @param invitation the new invitation
     */
    public void sendInvitation(Invitation invitation){
        invitation.send();
    }

    /**
     * gets all the invitations that has been sent to the player and put it in  a list
     * @return a list of all the invitation that has been sent to the player
     */
    public ArrayList<Invitation> receiveInvitations(){
        return DataSource.getInstance().getMyReceivedInvitations(ID);

    }



    @Override
    public String toString() {
        return "type "+ type +"name : " +name+ " ID :" + ID + " Email : "+ Email + " password" + passWord +"\n";
    }

    /**
     * adds a new booking the player by saving only the ID of the booking
     * @param bookingID the booking ID
     */
    public void addBookingID(String bookingID){
        bookingsID.add(bookingID);

    }

    public List<Booking> getMyBookings(){
        return  DataSource.getInstance().getPlayerBookings(bookingsID);
         

    }


}
