package GOFO.Users ;

import GOFO.Registering.I_LogIn;
import GOFO.Registering.I_SignUp;
import  java.lang.Character;

import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;


public class Player extends User implements I_LogIn , I_SignUp {


    private char aChar;


    /**
     * @author mohamed mohmoud said
     * this method is making sure that the name the user enters is vaild
     * is only valid is it is english char only
     * and return true when its right and false when the name is wrong
     * @param name
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

    @Override
    public boolean signUp_ID(String ID) {
        return false;
    }

    @Override
    public boolean signUp_Email(String Email) {
        return false;
    }

    @Override
    public void create_account() {

    }
}
