package GOFO.DataModel;

import GOFO.Users.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mohamed mahmoud said
 * @version v1.0
 * This class is singleton class which means it has only one object
 * this class is responsible for storing all the data about the player or the play ground owner and the admin
 * there will be in there some hard coded player and playGrounds for testing
 * this data will not be connect to any databases
 * maybe it will be stored in text file but that is not for sure yet
 * */
public class DataSource {
    public static  DataSource dataSource= null;
    List<Player> players;

    public static DataSource getInstance() {
        if(dataSource== null)
            dataSource = new DataSource();
        return dataSource;
    }


    private DataSource (){
        players = new ArrayList<Player>();

    }




}
