package GOFO.Users;
/**
 * @author mohamed mahmoud said
 * @version v1.0
 * this is the base class for the users that the basic info
 * need

 */
public class User {
    String ID;
    String name;
    String Email;
    String passWord;
    String type;
    public User() {
        this("none","none","none","none");

    }
    public User(String ID, String name, String email, String passWord) {
        this.ID = ID;
        this.name = name;
        Email = email;
        this.passWord = passWord;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        passWord = passWord;
    }


}
