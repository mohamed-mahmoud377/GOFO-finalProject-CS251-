
package GOFO.DataModel;

import GOFO.OwnerClasses.Booking;
import GOFO.OwnerClasses.Ground;
import GOFO.PlayerClasses.Invitation;
import GOFO.PlayerClasses.Team;
import GOFO.Registering.I_LogIn;
import GOFO.Users.Admin;
import GOFO.Users.Owner;
import GOFO.Users.Player;
import GOFO.Users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mohamed
 * @version v1.0
*  class is singleton class which means it has only one object
 * this class is responsible for storing all the data about the player or the play ground owner and the admin
 * there will be in there some hard coded player and playGrounds for testing
 * this data will not be connect to any databases
 * maybe it will be stored in text file but that is not for sure yet
 * */
public class DataSource implements I_LogIn {
    private static final DataSource dataSource= new DataSource();
     private final Admin admin ;
    private User loggedInUser;
    private final Team teamSelected;
    private final List<Player> players;
    private final List<Owner> owners;
    private final List<User> users;
    private final List<Team> teams;
    private final List <Invitation> invitations;

    /**@author mohamed moahmoud
     *
     * @return datsource  which is the only calss objcet
     *  void lkjsd;flkjasd;f;asldkjf
     */
    public static DataSource getInstance() {

        return dataSource;
    }


    private DataSource (){
        teamSelected=null;
        teams = new ArrayList<Team>();
        users= new ArrayList<User>();
        admin = new Admin("admin","admin","admin@gmail.com","admin");
        invitations = new ArrayList<Invitation>();
        players = new ArrayList<Player>();
        owners = new ArrayList<Owner>();


    }

    //  ///////////////////users


    public  boolean  checkUserIDIfValid(String ID){
        for(User i: users){
            if(ID.equals(i.getID())){
                return false;
            }
        }
        return true;


    }

    /**
     * @author jerr
     *
     * */
    public void addNewUser(User newUser){
        users.add(newUser);
    }
    public void printUsers(){
        for(User i :users){
            System.out.println(i);
        }
    }
    public void hardCodedUsers(){
        Player player1 = new Player("jerry11","mohamed ali","jerry ","roma");
        player1.addBookingID("pk11");
        player1.addBookingID("pk22");
        Player player2 = new Player("snoopy22","mohamed mahmoud","jerry ","roma22");
        player2.addBookingID("pk33");
        player2.addBookingID("pk44");

        Player player3 = new Player("free_for_all11","Mustafa hatem","jerry ",";roma");

        Player player4 = new Player("fresll","mohamed mahmoud","jerry ",";roma");
        Player player5 = new Player("whatthefuck","mohamed mahmoud","jerry ",";roma");
        Player player6 = new Player("gamer","mohamed ali","jerry ","roma");
        Player player7 = new Player("snower","mohamed mahmoud","jerry ","roma22");

        Player player8 = new Player("free_for_all","Mustafa hatem","jerry ",";roma");

        Player player9 = new Player("killer","mohamed mahmoud","jerry ",";roma");
        Player player10 = new Player("jerry33","mohamed mahmoud","jerry ",";roma");
        Owner owner1 = new Owner("jerry","roma","jerry@gamil.conm","Asa7be,com");
//        Ground ground1= new Ground()

        Owner owner2 = new Owner("roma","roma","jerry@gamil.con","Asa7be,com");
        Ground ground1 = new Ground("pg1","romaspalyground","aiaa jalsdkfj;aslkdfjajl;","sdfsdf"
                ,owner2.getID(),10,22,10,false);
        Booking booking1 = new Booking(10,12,"pk11","jerry11");

        Booking booking2 = new Booking(12,13,"pk22","jerry11");

        Booking booking3 = new Booking(16,17,"pk33","snoopy22");

        Booking booking4 = new Booking(18,20,"pk44","snoopy22");
        ground1.addBooking(booking1);
        ground1.addBooking(booking2);

        ground1.addBooking(booking3);

        ground1.addBooking(booking4);






        Ground ground2 =  new Ground ("pg2","comeon","lets play ","s;ldkfjs;al",owner2.getID(),8,22,10,false);
        owner2.addNewPlayGround(ground1);
        owner2.addNewPlayGround(ground2);
        Owner owner3 = new Owner("snooopy","roma","jerry@gamil.con","Asa7be,com");
        Ground ground3 = new Ground("pg3","snooopys play goutnd","lests go;","12 el gadf"
                ,owner3.getID(),4,20,15,false);
        Ground ground4 =  new Ground ("pg4","fuckyeah","yea baby ","s;ldkfdfjs;al",owner3.getID(),6,23,9,false);
        owner3.addNewPlayGround(ground3);
        owner3.addNewPlayGround(ground4);
        Owner owner4 = new Owner("aagsdfamer","roma","jerry@gamil.con","Asa7be,com");
        Owner owner5 = new Owner("wahetever","roma","jerry@gamil.con","Asa7be,com");
        users.add(player1);users.add(player2);users.add(player3);
        users.add(player4);users.add(player5);users.add(player6);users.add(player7);users.add(player8);
        users.add(player9);users.add(player10);users.add(owner1);
        users.add(owner2);users.add(owner3);users.add(owner4);users.add(owner5);
        for(User i : users){
            if(i.getType().equals("Player")){
                players.add((Player) i);
            }else if(i.getType().equals("Owner")){
                owners.add((Owner) i);
            }
        }


    }
    @Override
    public boolean checkInfo(String ID, String password) {
        if(ID.equals("admin") && password.equals("admin")){
            loggedInUser =  admin;
            return true;
        }
        for(User i:users){
            if(i.getID().equals(ID)){
                if(i.getPassWord().equals(password)){
                    loggedInUser = i;
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public User logIn() {
        return loggedInUser;
    }
    public List<User>getUsers(){
        return users;
    }



    /////////////////////////////// Player

    /**
     * @author mohamed moahmoud
     * @param ID
     * @return boolean when the Player is found to check if it is exist or not and this different from
     * is valid or not in case of valid we check if it was there wer return false not true
     */
    public boolean checkPlayerIDIfExist(String ID){
        for(User i: users){
            if(ID.equals(i.getID())){
                if(i.getType().equals("Player"))
                    return true;
            }
        }
        return false;

    }

    /**
     * @author mohamedMohamoud
     * @param ID
     * @return ArrayLIst of Invitations
     * this methos takes the player ID and search  throw all the invitations and gives us a list of invitations '
     * that sent to that player
     *
     *
     */
    public ArrayList<Invitation> getMyReceivedInvitations(String ID){
        ArrayList<Invitation> receivedInvitations = new ArrayList<Invitation>();
        for(Invitation i: invitations){
            for(String w : i.getReceiversID() ){
                if(w.equals(ID))
                    receivedInvitations.add(i);
            }
        }
        return receivedInvitations;

    }

    public void addNewPlayer(Player newPlayer){
        players.add(newPlayer);
    }



    public List<Player> getPlayers(){
        return players;
    }

    public List<Booking>getPlayerBookings(List<String> bookedIDs){
        List<Booking> PlayerBookings= new ArrayList<Booking>();
        for(Owner i : owners){
            for(Ground w : i.getPlaygrounds()){
                for(Booking q : w.getBookings()){
                    for(String e : bookedIDs){
                        if(e.equals(q.getID()))
                            PlayerBookings.add(q);
                    }
                }
            }
        }
        return PlayerBookings;
    }




    ///////////////////////////////////////// invitations


    public void addNewInvitation(Invitation newInvitation){
        invitations.add(newInvitation);
    }

    public void deleteReceiverByItsID( String invID, String iD){
        for(Invitation i :invitations){
            if(i.getID().equals(invID)){
                i.getReceiversID().remove(iD);
                }

            }
        }


    ///////////////// teams


    public void addNewTeam(Team newTeam){
        teams.add(newTeam);

    }

    public void printTeams(){
        for(Team i :teams){
           i.display();
        }
    }

    public Team getTeamByPlayerID(String PlayerID){
        for(Team i: teams){
            if(i.getTeamLeaderID().equals(PlayerID))
                return i;
        }
        return null;
    }

    public Team getTeamByID(String iD){
        for(Team i: teams){
            if(i.getID().equals(iD))
                return i;
        }
        return null;
    }

    public boolean checkTeamIDIfValid(String ID){
        for( Team i: teams){
            if(i.getID().equals(ID))
                return false;
        }
        return  true;
    }


    /////////////Owner

    public boolean checkPlayGroundIDIfValid(String ID){
        for(User i: users){
            if(i.getType().equals("Owner")){
               Owner w = (Owner) i;
               for(Ground q : w.getPlaygrounds()){
                   if(q.getID().equals(ID)){
                       return false;
                   }

               }

            }
        }
        return true;
    }

    public void addNewOwner(Owner newOwner){
        owners.add(newOwner);
    }
    public  List<Owner> getOwners(){
        return owners;
    }
}
