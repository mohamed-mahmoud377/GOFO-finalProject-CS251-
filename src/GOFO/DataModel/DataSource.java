
package GOFO.DataModel;

import GOFO.Users.Player;

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
public class DataSource {
    public static  DataSource dataSource= new DataSource();
    List<Player> players;

    public static DataSource getInstance() {

        return dataSource;
    }


    private DataSource (){
        players = new ArrayList<Player>();

    }
    public  boolean  check_player_ID_if_valid(String ID){
        for(Player i: players){
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






}
