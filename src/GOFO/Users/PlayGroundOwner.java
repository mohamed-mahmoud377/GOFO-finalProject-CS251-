package GOFO.Users;

import GOFO.Registering.I_LogIn;
import GOFO.Registering.I_SignUp;

public class PlayGroundOwner extends User implements I_LogIn, I_SignUp {

    @Override
    public boolean signUp_name(String name) {
        return false;
    }

    @Override
    public boolean signUp_ID(String ID) {
        return false;
    }

    @Override
    public boolean signUp_Email(String Email) {
        return false;
    }

    @Override
    public boolean signUp_password(String password) {
        return false;
    }

    @Override
    public void create_account() {

    }
}
