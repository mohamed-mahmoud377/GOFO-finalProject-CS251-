package GOFO.Users ;

import GOFO.DataModel.DataSource;
import GOFO.PlayerClasses.Invitation;
import GOFO.PlayerClasses.Team;
import GOFO.Registering.I_SignUp;
import GOFO.Registering.I_UdataInfo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;


public class Player extends User implements  I_SignUp , I_UdataInfo {
    String myTeamID;
    List<String> joinedTeamsIDs;
    List <String> bookingsID;

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
     * @author mohamed mohmoud said
     * this method is making sure that the name the user enters is vaild
     * is only valid is it is english char only
     * and return true when its right and false when the name is wrong
     * @param name the given name by the user
     * @return boolean
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
     * @author mohamed mahmoud
     * @param ID the given ID by the user
     * @return boolean

     * it checks if the given ID is valid or not and if it is taken before or not
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

    @Override
    public boolean signUp_Email(String Email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        this.Email = Email;
        return Email.matches(regex);


    }

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

    @Override
    public void create_account() {
        DataSource.getInstance().addNewUser(this);

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

    public void addMyTeam(Team team){
         myTeamID = team.getID();
        DataSource.getInstance().addNewTeam(team);

    }
    public void addJoinedTeam(String teamID){
        joinedTeamsIDs.add(teamID);
    }

 // invitations

    public void sendInvitation(Invitation invitation){
        invitation.send();
    }
    public ArrayList<Invitation> receiveInvitations(){
        return DataSource.getInstance().getMyReceivedInvitations(ID);

    }



    @Override
    public String toString() {
        return "type "+ type +"name : " +name+ " ID :" + ID + " Email : "+ Email + " password" + passWord +"\n";
    }


}
