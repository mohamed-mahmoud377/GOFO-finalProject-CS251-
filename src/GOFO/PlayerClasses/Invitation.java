package GOFO.PlayerClasses;


import GOFO.DataModel.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * it has all the info needed about the invitation and responsible for sending and receiving the invitations
 * @author mohamed mahmoud
 */
public class Invitation {
    private static int IDNum=0;
    private String ID;
    private String massage;
    private String senderID;
    private String teamInvitedID;
    private List<String> receiversID;

    public static int getIDNum() {
        return IDNum;
    }

    public static void setIDNum(int IDNum) {
        Invitation.IDNum = IDNum;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTeamInvitedID() {
        return teamInvitedID;
    }

    public void setTeamInvitedID(String teamInvited) {
        this.teamInvitedID = teamInvited;
    }

    public Invitation (){
        senderID= "not known yet";
        receiversID = new ArrayList<String>();
        massage="none";
        IDNum ++;
        ID = "inv"+IDNum;
        teamInvitedID = "none";
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public  Invitation(String senderID, List<String> receiversID, String massage){
        this.senderID = senderID;
        this.receiversID = receiversID;
        this.massage = massage;
        IDNum ++;
        ID = "inv"+IDNum;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public List<String> getReceiversID() {
        return receiversID;
    }

    public void setReceiversID(List<String> receiversID) {
        this.receiversID = receiversID;
    }

    /**
     * add the current invitation to dataSource to be assessable to all the Players
     */
    public void send(){
        DataSource.getInstance().addNewInvitation(this);
    }

    /**
     * adds a player ID to list of the receivers which is the player that is going to receive this invitation
     * @param ID the player ID
     */
    public void addReceiver(String ID){
        receiversID.add(ID);
    }

    /**
     * check if the Player ID gavin is valid or not
     * @param ID the player ID
     * @return return true if the ID is right and it is the sender ID and false if is not valid
     */
    public boolean checkReceiverID( String ID){
        if(ID.equals(senderID))
            return false;
        for(String i: receiversID){
            if(i.equals(ID))
                return false;
        }
        return DataSource.getInstance().checkPlayerIDIfExist(ID);

    }

    /**
     * display all the info need about the invitation
     */
    public void display (){
        System.out.println("Invitation ID :" +ID);
        System.out.println(senderID+" wants you to join his teem " );
        System.out.println("content of the massage :" +massage);
        System.out.println(" Invited team ID "+teamInvitedID);
    }

    /**
     * display all the players that has received this invitation
     */
    public void displayReceivers(){
        for(String ID : receiversID){
            System.out.print(ID +"  ");
        }
    }

    /**
     * take the player ID and remove ID from the list that has all the IDs of the receivers
     * @param ID the ID of the player that is going to be deleted
     */
    public  void deleteReceiverByItsID(String ID){
        DataSource.getInstance().deleteReceiverByItsID(this.ID,ID);

    }
}
