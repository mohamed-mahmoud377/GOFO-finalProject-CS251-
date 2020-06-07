package GOFO.Users;

import GOFO.DataModel.DataSource;
import GOFO.OwnerClasses.Ground;
import GOFO.Registering.I_SignUp;
import GOFO.Registering.I_UdataInfo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;

/**
 *class that contain every thing about the owner and his playerGrounds
 * @author abderaham fesal

 */
public class Owner extends User implements  I_SignUp , I_UdataInfo {
    private String accountNumber;
    private String address;
    private List<Ground>playgrounds;

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

    /**
     * checks of the account number is valid or not it should be digits and only 12
     * @param accountNumber the account number entered from the Owner
     * @return true if the account is valid false if not
     */
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

    /**
     * checks if the name is valid or  not
     * @param name the name entered by the user
     * @return true if the name is valid
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
    /**
     * checks if the ID exist in the date source or not and if it there so it is not valid and return false
     * and if it not there will return true
     * @param ID the ID of the Onwer
     * @return true of the ID is valid and does not exist in the data source and false if the opposite
     */
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

    /**
     * checks if the the email entered is valid or not from its string only
     * @param Email the email entered by the user
     * @return true if the email were valid
     */
    @Override
    public boolean signUp_Email(String Email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        this.Email = Email;
        return Email.matches(regex);

    }

    /**
     * checks if the password is valid or not it is valid if it has at least one capital alphabet and one number and
     * at least 8 char
     * @param password the password entered by the Owner
     * @return true if the password is valid false if not
     */
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

    /**
     * creates a new account by adding it to dataSource class
     */
    @Override
    public void create_account() {
        DataSource.getInstance().addNewUser(this);
        DataSource.getInstance().addNewOwner(this);
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
    /**
     * adds a new playground to the list of the playgrounds
     * @param newGround the brand new playGround added by the user
     */
    public void addNewPlayGround(Ground newGround){
        playgrounds.add(newGround);
    }
}
