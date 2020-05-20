package GOFO.Users;

import GOFO.Registering.I_LogIn;
import GOFO.Registering.I_SignUp;

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
