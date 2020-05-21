package GOFO.OwnersData;

import GOFO.DataModel.DataSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDefined;
import static java.lang.Character.isWhitespace;

public class Team {

    String ID;
    String teamLeaderID;
    List<String> invitedPlayersIDs;



    public Team(){
        invitedPlayersIDs = new ArrayList<String>();
        teamLeaderID = "none";
        ID= "none";
    }

    @Override
    public String toString() {
        return "Team{" +
                "ID='" + ID + '\'' +
                ", teamLeaderID='" + teamLeaderID + '\'' +
                ", invitedPlayersIDs=" + invitedPlayersIDs +
                '}';
    }

    public boolean signUpID(String iD){
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


}
