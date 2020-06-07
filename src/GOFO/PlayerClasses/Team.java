package GOFO.PlayerClasses;

import GOFO.DataModel.DataSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDefined;
import static java.lang.Character.isWhitespace;

/**
 * has all the info needed for the team
 * @author mohamed mahomud
 * @version  1.0
 */
public class Team {

    private String ID;
    private String teamLeaderID;
    private final List<String> invitedPlayersIDs;


    public Team(String ID, String teamLeaderID, List<String> invitedPlayersIDs) {
        this.ID = ID;
        this.teamLeaderID = teamLeaderID;
        this.invitedPlayersIDs = invitedPlayersIDs;
    }

    public Team(){
        invitedPlayersIDs = new ArrayList<String>();
        teamLeaderID = "none";
        ID= "none";
    }

    @Override
    public String toString() {
        return "Team ID : " +ID +" ";
    }

    /**
     * checks that the given ID is valid or not
     * @param ID the ID entered by the player
     * @return true of the ID is valid false if not
     */
    public boolean signUpID(String ID){
        if( DataSource.getInstance().checkTeamIDIfValid(ID)) {
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
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }





    public String getTeamLeaderID() {
        return teamLeaderID;
    }

    public List<String> getInvitedPlayersIDs() {
        return invitedPlayersIDs;
    }

    public void setTeamLeaderID(String teamLeaderID) {
        this.teamLeaderID = teamLeaderID;
    }

    /**
     * add a new player for the invited player ID list
     * @param PlayerID player ID
     */
    public void addInvitedPlayer(String PlayerID){
        invitedPlayersIDs.add(PlayerID);

    }

    /**
     * display all the info need about the team
     */
    public void display(){
        int w=1;
        System.out.println("Team ID : " + ID);
        System.out.println("caption : "+teamLeaderID);
        System.out.println("Players :");
        for(String i : invitedPlayersIDs ){
            System.out.println(  "          ["+ w+"]" + i);
            w++;
        }

    }


}

