package GOFO.PlayerClasses;

import GOFO.DataModel.DataSource;
import GOFO.OwnerClasses.Ground;
import GOFO.Users.Owner;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility Class that has all the method needed to preform all kind of searching
 * @author abderham fesal
 * @version 1.0
 */
public class Search {
    /**
     * this method let the player view all the available playgrounds
     * @return a list of Grounds that has all the available Grounds for the player to view
     */
    public static List<Ground> ViewAllGrounds () {
        List<Owner> owners = DataSource.getInstance().getOwners();
        List<Ground> grounds= new ArrayList<Ground>();
        for(Owner i : owners){
            for(Ground w : i.getPlaygrounds()){
                if(!w.isSuspended()){
                    grounds.add(w);
                }
            }
        }


        return grounds;
    }

    /**
     * the player enter a specific range of staring and ending time and and will return a list
     * of the playGround that is available is this time
     * @param start the staring time
     * @param end   the ending time
     * @return a list of the available playgrounds
     */
    public static List<Ground>  searchBySpecificRangeOfDateAndTime(int start , int end) {
    List<Owner> owners = DataSource.getInstance().getOwners();
    List<Ground> grounds = new ArrayList<>();
    for (Owner i : owners) {
        for (Ground w : i.getPlaygrounds()) {
            if (w.checkBooking(start, end)) {
                if (!w.isSuspended()) {
                    grounds.add(w);
                }
            }
        }
    }

return grounds;
}
}
