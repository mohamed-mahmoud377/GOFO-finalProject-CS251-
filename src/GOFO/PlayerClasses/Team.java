package GOFO.PlayerClasses;

import GOFO.DataModel.DataSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDefined;
import static java.lang.Character.isWhitespace;

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
    public void addInvitedPlayer(String PlayerID){
        invitedPlayersIDs.add(PlayerID);

    }
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

