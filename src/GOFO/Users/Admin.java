package GOFO.Users;


/**
 * class that is  representing the admin
 */
public class Admin extends User  {

    public Admin() {
        super();
        type="Admin";
    }

    public Admin(String ID, String name, String email, String passWord) {
        super(ID, name, email, passWord);
        type="Admin";
    }


}
