package GOFO.Users ;

import GOFO.DataModel.DataSource;
import GOFO.Registering.I_LogIn;
import GOFO.Registering.I_SignUp;
import GOFO.verification.Verify;

import  java.lang.Character;
import java.util.Scanner;

import static java.lang.Character.*;


public class Player extends User implements I_LogIn , I_SignUp {


    public Player(){
        super();


    }

    public Player(String ID, String name, String email, String passWord) {
        super(ID, name, email, passWord);
    }

    /**
     * @author mohamed mohmoud said
     * this method is making sure that the name the user enters is vaild
     * is only valid is it is english char only
     * and return true when its right and false when the name is wrong
     * @param name the given name by the user
     * @return boolean
     */
    @Override
    public boolean signUp_name(String name) {
        name = name.trim();
      for(int i=0;i<name.length();i++){
          char a = name.charAt(i);
          if(!isLetter(a) &&!isWhitespace(a)){
              return false;
          }

      }
      return true;
    }

    /**
     * @author mohamed mahmoud
     * @param ID the given ID by the user
     * @return boolean

     * it checks if the given ID is valid or not and if it is taken before or not
     */
    @Override
    public boolean signUp_ID(String ID) {
        if( DataSource.getInstance().check_player_ID_if_valid(ID)) {
            for (int i = 0; i < ID.length(); i++) {
                char a = ID.charAt(i);
                if (!isDefined(a) || isWhitespace(a)) {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    @Override
    public boolean signUp_Email(String Email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return Email.matches(regex);


    }

    @Override
    public boolean signUp_password(String password) {
        if(password.length()<8)
            return false;
    }

    @Override
    public void create_account() {

    }
}
