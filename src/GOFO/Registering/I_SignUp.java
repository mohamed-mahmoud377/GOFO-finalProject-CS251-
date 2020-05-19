package GOFO.Registering;

public interface I_SignUp {
    /**
     * @author mohamed mohmoud said
     * this method is making sure that the name the user enters is vaild
     * is only valid is it is english char only
     * and return true when its right and false when the name is wrong
     * @param name the given name by the user
     * @return boolean
     */
    boolean signUp_name(String name);

    boolean signUp_ID(String ID);

    boolean signUp_Email(String Email);
    void create_account ();

}
