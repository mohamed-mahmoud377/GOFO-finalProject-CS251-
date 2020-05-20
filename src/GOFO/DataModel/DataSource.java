
package GOFO.DataModel;

import GOFO.OwnersData.Team;
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
    Team teamSelected;
    List<User> users;
    List<Team> teams;

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

    }
    public boolean checkTeamIDIfValid(String ID){
        for( Team i: teams){
            if(i.getID().equals(ID))
                return false;
        }
        return  true;
    }

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
    public void addNewTeam(Team newTeam){
        teams.add(newTeam);

    }
    public void printUsers(){
        for(User i :users){
            System.out.println(i);
        }
    }
    public void hardCodedUsers(){
        Player player1 = new Player("jerry11","mohamed ali","jerry ","roma");
        Player player2 = new Player("snoopy22","mohamed mahmoud","jerry ","roma22");

        Player player3 = new Player("free_for_all11","Mustafa hatem","jerry ",";roma");

        Player player4 = new Player("fresll","mohamed mahmoud","jerry ",";roma");
        Player player5 = new Player("whatthefuck","mohamed mahmoud","jerry ",";roma");
        Player player6 = new Player("gamer","mohamed ali","jerry ","roma");
        Player player7 = new Player("snower","mohamed mahmoud","jerry ","roma22");

        Player player8 = new Player("free_for_all","Mustafa hatem","jerry ",";roma");

        Player player9 = new Player("killer","mohamed mahmoud","jerry ",";roma");
        Player player10 = new Player("jerry33","mohamed mahmoud","jerry ",";roma");
        PlayGroundOwner owner1 = new PlayGroundOwner("jerry","roma","jerry@gamil.conm","Asa7be,com");

        PlayGroundOwner owner2 = new PlayGroundOwner("roma","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner3 = new PlayGroundOwner("snooopy","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner4 = new PlayGroundOwner("aagsdfamer","roma","jerry@gamil.con","Asa7be,com");
        PlayGroundOwner owner5 = new PlayGroundOwner("wahetever","roma","jerry@gamil.con","Asa7be,com");
        users.add(player1);
        users.add(player2);
        users.add(player3);
        users.add(player4);
        users.add(player5);
        users.add(player6);
        users.add(player7);
        users.add(player8);
        users.add(player9);
        users.add(player10);
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
