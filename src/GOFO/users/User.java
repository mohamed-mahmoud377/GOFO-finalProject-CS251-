package GOFO.users;

import javax.print.Doc;

/**
 * @author  mohamed mahmoud said
 * @version v1.0
 *
 * this class is the base class for all users
 *

 */
public class User {

    String ID ;
    String Name ;
    String Email;
    String passWOrd;

    public User(String ID, String name, String email, String passWOrd) {
        this.ID = ID;
        Name = name;
        Email = email;
        this.passWOrd = passWOrd;
    }
}
