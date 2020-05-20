
package GOFO.DataModel;

import GOFO.Registering.I_LogIn;
import GOFO.Users.Admin;
import GOFO.Users.PlayGroundOwner;
import GOFO.Users.Player;
import GOFO.Users.User;

import java.util.ArrayList;
import java.util.List;
/**
 * @custom.mytag hey ho...
 */
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
    public static  DataSource dataSource= new DataSource();
    Admin admin ;
    User loggedInUser;
    List<User> users;
    List<Player> players;
    List<PlayGroundOwner> owners;

    public static DataSource getInstance() {

        return dataSource;
    }


    private DataSource (){
        players = new ArrayList<Player>();
        owners = new ArrayList<PlayGroundOwner>();
        users= new ArrayList<User>();
        admin = new Admin("admin","admin","admin@gmail.com","admin");

    }
    public  boolean  check_User_ID_if_valid(String ID){
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
    public void hard_coded_players(){
        Player player1 = new Player("jerry377","mohamed ali","jerry ",";roma");
        Player player2 = new Player("snoopy","mohamed mahmoud","jerry ",";roma");

        Player player3 = new Player("free_for_all","Mustafa hatem","jerry ",";roma");

        Player player4 = new Player("killer","mohamed mahmoud","jerry ",";roma");
        Player player5 = new Player("jerry33","mohamed mahmoud","jerry ",";roma");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);

    }
    public void hard_coded_Owners(){
        PlayGroundOwner owner1 = new PlayGroundOwner("jerry","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner2 = new PlayGroundOwner("roma","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner3 = new PlayGroundOwner("snoopy","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner4 = new PlayGroundOwner("aagamer","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner5 = new PlayGroundOwner("wahet ever","roma","jerry@gamil.con","Asa7be,com");
        owners.add(owner1);
        owners.add(owner2);
        owners.add(owner3);
        owners.add(owner4);
        owners.add(owner5);



    }
    public void addNewUser(User newUser){
        users.add(newUser);
    }
    public void printUsers(){
        for(User i :users){
            System.out.println(i);
        }
    }
    public void hardCodedUsers(){
        Player player1 = new Player("jerry377","mohamed ali","jerry ",";roma");
        Player player2 = new Player("snoopy","mohamed mahmoud","jerry ",";roma");

        Player player3 = new Player("free_for_all","Mustafa hatem","jerry ",";roma");

        Player player4 = new Player("killer","mohamed mahmoud","jerry ",";roma");
        Player player5 = new Player("jerry33","mohamed mahmoud","jerry ",";roma");
        PlayGroundOwner owner1 = new PlayGroundOwner("jerry","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner2 = new PlayGroundOwner("roma","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner3 = new PlayGroundOwner("snoopy","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner4 = new PlayGroundOwner("aagamer","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner5 = new PlayGroundOwner("wahet ever","roma","jerry@gamil.con","Asa7be,com");
        users.add(player1);
        users.add(player2);
        users.add(player3);
        users.add(player4);
        users.add(player5);
        users.add(owner1);
        users.add(owner2);
        users.add(owner3);
        users.add(owner4);
        users.add(owner5);

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
}
