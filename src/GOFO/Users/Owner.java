package GOFO.Users;

import GOFO.DataModel.DataSource;
import GOFO.OwnerClasses.Ground;
import GOFO.Registering.I_SignUp;
import GOFO.Registering.I_UdataInfo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;

public class Owner extends User implements  I_SignUp , I_UdataInfo {
    String accountNumber;
    String address;
    List<Ground>playgrounds;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Ground> getPlaygrounds() {
        return playgrounds;
    }

    public void setPlaygrounds(List<Ground> playgrounds) {
        this.playgrounds = playgrounds;
    }

    public void signUp_address(String address){
        this.address=address;
    }
    public boolean signUp_accountNumber(String accountNumber){
        if(!(accountNumber.length()==12))
            return false;
        for (int i=0;i<accountNumber.length();i++){
            if(!isDigit(accountNumber.charAt(i))){
                return false;
            }
        }
        this.accountNumber=accountNumber;
        return true;

    }

    @Override
    public boolean signUp_name(String name) {
        name = name.trim();
        for(int i=0;i<name.length();i++){
            char a = name.charAt(i);
            if(!isLetter(a) &&!isWhitespace(a)){
                return false;
            }

        }
        this.name = name;
        return true;
    }

    public Owner() {
        super();
        type = "Owner";
        accountNumber= "none";
        address  = "none";
        playgrounds = new ArrayList<Ground>();


    }

    public Owner(String ID, String name, String email, String passWord) {
        super(ID, name, email, passWord);
        type = "Owner";
        accountNumber= "none";
        address  = "none";
        playgrounds = new ArrayList<Ground>();

    }

    @Override
    public boolean signUp_ID(String ID) {
        if( DataSource.getInstance().checkUserIDIfValid(ID)) {
            for (int i = 0; i < ID.length(); i++) {
                char a = ID.charAt(i);
                if (!isDefined(a) || isWhitespace(a)) {
                    return false;
                }
            }
        }else {
            return false;
        }
        this.ID = ID;
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean signUp_Email(String Email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        this.Email = Email;
        return Email.matches(regex);

    }

    @Override
    public boolean signUp_password(String password) {
        boolean num_check = false;
        boolean cap_check = false;
        if(password.length()<8)
            return false;
        for(int i=0 ;i<password.length();i++){
            if(isUpperCase(password.charAt(i)))
                cap_check = true;
            if(isDigit(password.charAt(i)))
                num_check=true;

        }
        this.passWord = password;
        return num_check && cap_check;
    }

    @Override
    public void create_account() {
        DataSource.getInstance().addNewUser(this);
    }

    @Override
    public String toString() {
        return "type "+ type +"name : " +name+ " ID :" + ID + " Email : "+ Email + " password" + passWord +"\n";

    }

    @Override
    public boolean chanceName(String name) {
        return false;
    }

    @Override
    public boolean chancePassword(String password) {
        return false;
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
    public void addNewPlayGround(Ground newGround){
        playgrounds.add(newGround);
    }
}
