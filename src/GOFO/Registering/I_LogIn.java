package GOFO.Registering;

import GOFO.Users.User;

public interface I_LogIn {
    boolean checkInfo(String ID,String password);
   User logIn();

}
