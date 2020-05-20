package GOFO.OwnersData;

import java.util.ArrayList;
import java.util.List;

public class Team {
    String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    String teamLeaderID;
    List<String> invitedPlayersIDs;



    public String getTeamLeaderID() {
        return teamLeaderID;
    }

    public List<String> getInvitedPlayersIDs() {
        return invitedPlayersIDs;
    }

    public void setTeamLeaderID(String teamLeaderID) {
        this.teamLeaderID = teamLeaderID;
    }

    public Team(){
        invitedPlayersIDs = new ArrayList<String>();
        teamLeaderID = "none";
    }
}
