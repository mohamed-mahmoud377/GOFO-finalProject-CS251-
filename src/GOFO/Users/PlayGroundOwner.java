package GOFO.Users;

import GOFO.Registering.I_LogIn;
import GOFO.Registering.I_SignUp;

public class PlayGroundOwner extends User implements  I_SignUp {

    @Override
    public boolean signUp_name(String name) {
        return false;
    }

    public PlayGroundOwner() {
        super();
        type = "Owner";

    }

    public PlayGroundOwner(String ID, String name, String email, String passWord) {
        super(ID, name, email, passWord);
        type = "Owner";

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

    @Override
    public String toString() {
        return "type "+ type +"name : " +name+ " ID :" + ID + " Email : "+ Email + " password" + passWord +"\n";

    }
    //    @Override
//    public boolean checkInfo(String ID,String password) {
//        return false;
//    }
//
//    @Override
//    public boolean logIn() {
//        return false;
//    }
}
