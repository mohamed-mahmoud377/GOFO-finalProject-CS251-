
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

 *  class is singleton class which means it has only one object
 * this class is responsible for storing all the data about the player or the play ground owner and the admin
 * it will all the methods needed to get the data needed for the application
 * there will be in there some hard coded player and playGrounds for testing
 * this data will not be connect to any databases
 * maybe it will be stored in text file but that is not for sure yet
 *  @author mohamed
 *  * @version v1.0
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

    /**
     * it return the static variable for the singleton class
     * @return dataSource - which the a static variable that will be used all over the program
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
    /*

     */

    /**
     * checks the ID of the user whether a player or an owner and if it exist it return false so it is not valid and
     * duplicated and cant be signed
     * @param ID the ID of the player of the Owner
     * @return true if the the ID is valid means it is not exist before in the list and it has an unique value
     * and false if it was int the list of users
     */
    public  boolean  checkUserIDIfValid(String ID){
        for(User i: users){
            if(ID.equals(i.getID())){
                return false;
            }
        }
        return true;


    }

    /**
     * it adds a new user to the list of users and he can be a player or an owner
     * @param newUser a new user who has just signed up
     */
    public void addNewUser(User newUser){
        users.add(newUser);
    }

    /**
     * prints all the users that is in the system form Player and Owners
     */
    public void printUsers(){
        for(User i :users){
            System.out.println(i);
        }
    }

    /**
     * it add a lot of hard coded data form player and owner and playground to test the program on
     * because there is no database to store the data in in the current version
     */
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

    /**
     * while the player or the owner are logging in this method checks if the given ID and password are correct
     * or not
     * @param ID the user ID that he uses to log in
     * @param password the user password that he uses to log in
     * @return return return true if the data given were correct and false if it was wrong
     */
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

    /**
     * it returns the User who has just logged in successfully
     * @return a User who has just logged in
     */
    @Override
    public User logIn() {
        return loggedInUser;
    }

    /**
     * return a list of all the user of the system
     * @return a list of all the users
     */
    public List<User>getUsers(){
        return users;
    }



    /////////////////////////////// Player

    /**
     * checks if the given ID of the player is exist in the Users list or not
     * @param ID the Player ID
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
     * this method takes the player ID and search  throw all the invitations and gives us a list of invitations '
     * that sent to that player
     * @param ID the player ID
     * @return ArrayLIst of Invitations

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

    /**
     * it adds a new player to the players list that contain all the player in the system
     * @param newPlayer a brand new player who has just signed up
     */
    public void addNewPlayer(Player newPlayer){
        players.add(newPlayer);
    }


    /**
     * return a list of the player in the system
     *
     */
    public List<Player> getPlayers(){
        return players;
    }

    /**
     * yoy give this function the IDs of the bookings that the player has booked and it return the
     * actual bookings
     * @param bookedIDs the IDs of the bookings that the player has booked before
     * @return a list of bookings class that the player has booked
     */
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

    /**
     * it add a new invitation to the invitations list
     * @param newInvitation a brnad new invitation that will be saved in the list
     */
    public void addNewInvitation(Invitation newInvitation){
        invitations.add(newInvitation);
    }

    /**
     * it remove a the player form the sent invitation we he reject it
     * @param invID the ID of the invitation
     * @param iD the ID of the player
     */
    public void deleteReceiverByItsID( String invID, String iD){
        for(Invitation i :invitations){
            if(i.getID().equals(invID)){
                i.getReceiversID().remove(iD);
                }

            }
        }


    ///////////////// teams

    /**
     * adds a brand new team to the list of teams
     * @param newTeam a brand new team
     */
    public void addNewTeam(Team newTeam){
        teams.add(newTeam);

    }

    /**
     * display all of the team in the teams list
     */
    public void printTeams(){
        for(Team i :teams){
           i.display();
        }
    }

    /**
     * it return the team by its leader ID
     * @param PlayerID the team Leader ID
     * @return return the team of the ID were correct and return null of false
     */
    public Team getTeamByPlayerID(String PlayerID){
        for(Team i: teams){
            if(i.getTeamLeaderID().equals(PlayerID))
                return i;
        }
        return null;
    }

    /**
     * return the team by the team ID
     * @param iD the team ID
     * @return if  the ID is correct it will return the team if not will return null
     */
    public Team getTeamByID(String iD){
        for(Team i: teams){
            if(i.getID().equals(iD))
                return i;
        }
        return null;
    }

    /**
     * if the Team ID were already exist in the list of the team in will return false
     * if it is a unique one it will return true
     * @param ID the team ID
     *
     */
    public boolean checkTeamIDIfValid(String ID){
        for( Team i: teams){
            if(i.getID().equals(ID))
                return false;
        }
        return  true;
    }


    /////////////Owner

    /**
     * checks if the given ID of the Owner is exist in the Users list or not
     * @param ID the Player ID
     * @return boolean when the Player is found to check if it is exist or not and this different from
     * is valid or not in case of valid we check if it was there wer return false not true
     */
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

    /**
     * add a a brand new Owner to the list of Owners
     * @param newOwner a new Owner who has just signed up
     */
    public void addNewOwner(Owner newOwner){
        owners.add(newOwner);
    }

    /**
     * return all the owner in the system in a list
     * @return list of all the Owners
     */
    public  List<Owner> getOwners(){
        return owners;
    }
}
