package GOFO.PlayerClasses;

import GOFO.DataModel.DataSource;
import GOFO.OwnerClasses.Ground;
import GOFO.Users.Owner;

import java.util.ArrayList;
import java.util.List;

public class Search {

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
