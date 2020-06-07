

package GOFO.contorllers;

import GOFO.DataModel.DataSource;
import GOFO.Users.Owner;
import GOFO.Users.Player;
import GOFO.Users.User;
import GOFO.verification.Verify;

import java.util.Scanner;

/**
 * this class is a utility class ans also we can consider it as a control class that allow the user to
 * sign up and log in through static methods that will be used in the main to reduce the code there and keep
 * it more arranged
 * @author mohamed mahmoud
 */
public class HomeScreen {
    private HomeScreen(){}
    /**
     * this static method is responsible for the user to log in the player of the owner by entering their
     * ID and password and it will use the data source to check for the ID and the password if it is right
     * or not
     * @return User which is the the user how has already logged in it can be an admin or a player or an owner
     *
     */
    public static User userLogIn(){
        String string_input;
        int int_input = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);


            System.out.println("ID :");
            string_input = scanner.nextLine();
            String userID = string_input;
            System.out.println("Password :");
            string_input = scanner.nextLine();
            String userPassword = string_input;
            while (!DataSource.getInstance().checkInfo(userID, userPassword)) {
                System.out.println("you user name or pass word is incorrect ");
                System.out.println("ID :");
                string_input = scanner.nextLine();
                userID = string_input;
                System.out.println("Password :");
                string_input = scanner.nextLine();
                userPassword = string_input;
            }
            User loggedInUser = DataSource.getInstance().logIn();
            System.out.println("Logged in successfully");

            return loggedInUser;

    }
    /**
     *static method for the player to sign up it creates a new player and make the user enter all the need
     * info to sign up the player account and it uses player class methods to sign up player info in a correct way
     * and it has a connection to the internet through the  verify class to verify the player Gmail
     * and it calls all the need methods for that
     * @return Player
     * which is the player who just already singed up
     */
    public static Player playerSigningUp(){
        String string_input;
        int int_input = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Player currentPlayer = new Player();
//        scanner.nextLine();//clean the buffer
        System.out.println("enter your full name ");
        string_input=scanner.nextLine();

        while(!currentPlayer.signUp_name(string_input)){
            //while get into this loop if the user entered a wrong user name
            //only char works
            System.out.println("the name entered is not valid only english char works");
            string_input=scanner.nextLine();

        }
        String playerFullName = string_input;
//                            scanner.nextLine();
        System.out.println("enter your ID it (must be unique one) :  ");
        string_input= scanner.nextLine();
        while(!currentPlayer.signUp_ID(string_input)){
            System.out.println("the ID you entered is not valid or maybe taken");
            string_input=scanner.nextLine();

        }
        System.out.println("accepted \n your ID is : " + string_input);
        String PlayerID= string_input;
//                            scanner.nextLine();
        System.out.println("enter you password :");
        string_input= scanner.nextLine();
        while(!currentPlayer.signUp_password(string_input)){
            System.out.println("the password you entered is not valid \n" +
                    "add at least one number and one capital alphabet and it is more than 8 character");
            string_input=scanner.nextLine();

        }

        while(true){
            System.out.println("enter your Gmail : ");
//                            scanner.nextLine();
            string_input= scanner.nextLine();
            while(!currentPlayer.signUp_Email(string_input)){
                System.out.println("the entered email is not valid");
                System.out.println("enter you Gmail :");
                string_input = scanner.nextLine();
            }
            System.out.println("sending");
            while(!Verify.send_verify_code(string_input,playerFullName)){
                System.out.println("something went wrong check you internet connection or try to enter the email again");
                System.out.println("enter you Gmail :");
                string_input = scanner.nextLine();

            }
            System.out.println("a verification code is sent to your email");
            System.out.println("[1] enter the code");
            System.out.println("[2] resent ");
            int_input= scanner1.nextInt();
            if(int_input==1){
                System.out.println("code :");
                int_input = scanner1.nextInt();
                if(!Verify.check_validation_code(int_input)){
                    System.out.println("the verification code is wrong please enter the Email again");
//                                            scanner.nextLine();
                    continue;
                }
                currentPlayer.create_account();
                System.out.println(" congratulations ! \nyou have registered successfully ");
                break;



            }else if(int_input ==2){
                continue;

            }else {
                System.out.println("enter a valid value !");
            }
        }

        return currentPlayer;

    }
    /**
            *static method for the owner to sign up it creates a new owner and make the user enter all the need
     * info to sign up the owner account and it uses player class methods to sign up player info in a correct way
     * and it has a connection to the internet through the  verify class to verify the Owner Gmail
     * and it calls all the need methods for that
     * @return Onwer
     * which is the player who just already singed up
     */
    public static Owner ownerSigningUp(){
        String string_input;
        int int_input = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Owner currentOwner = new Owner();
//        scanner.nextLine();//clean the buffer
        System.out.println("enter your full name ");
        string_input=scanner.nextLine();

        while(!currentOwner.signUp_name(string_input)){
            //while get into this loop if the user entered a wrong user name
            //only char works
            System.out.println("the name entered is not valid only english char works");
            string_input=scanner.nextLine();

        }
        String playerFullName = string_input;
//                            scanner.nextLine();
        System.out.println("enter your ID it (must be unique one) :  ");
        string_input= scanner.nextLine();
        while(!currentOwner.signUp_ID(string_input)){
            System.out.println("the ID you entered is not valid or maybe taken");
            string_input=scanner.nextLine();

        }
        System.out.println("accepted \n your ID is : " + string_input);
        String PlayerID= string_input;
//                            scanner.nextLine();
        System.out.println("enter you password :");
        string_input= scanner.nextLine();
        while(!currentOwner.signUp_password(string_input)){
            System.out.println("the password you entered is not valid \n" +
                    "add at least one number and one capital alphabet and it is more than 8 character");
            string_input=scanner.nextLine();

        }
        System.out.println("enter you account number");
        string_input = scanner.nextLine();
        while(!currentOwner.signUp_accountNumber(string_input)){
            System.out.println("something is wrong (number must be 12 digits)");
            string_input = scanner.nextLine();
        }
        System.out.println("enter you address");
        string_input=scanner.nextLine();
        currentOwner.signUp_address(string_input);


        System.out.println("enter you PlayGround info");


        while(true){
            System.out.println("enter your Gmail : ");
//                            scanner.nextLine();
            string_input= scanner.nextLine();
            while(!currentOwner.signUp_Email(string_input)){
                System.out.println("the entered email is not valid");
                System.out.println("enter you Gmail :");
                string_input = scanner.nextLine();
            }
            System.out.println("sending");
            while(!Verify.send_verify_code(string_input,playerFullName)){
                System.out.println("something went wrong check you internet connection or try to enter the email again");
                System.out.println("enter you Gmail :");
                string_input = scanner.nextLine();

            }
            System.out.println("a verification code is sent to your email");
            System.out.println("[1] enter the code");
            System.out.println("[2] resent ");
            int_input= scanner1.nextInt();
            if(int_input==1){
                System.out.println("code :");
                int_input = scanner1.nextInt();
                if(!Verify.check_validation_code(int_input)){
                    System.out.println("the verification code is wrong please enter the Email again");
//                                            scanner.nextLine();
                    continue;
                }
                currentOwner.create_account();
                System.out.println(" congratulations ! \nyou have registered successfully ");
//                DataSource.getInstance().printUsers();
                break;



            }else if(int_input ==2){
                continue;

            }else {
                System.out.println("enter a valid value !");
            }
        }





        return currentOwner;

    }/**
     prints the first screen for the program that allow the user to lon in ofr sign up or sign up as an Owner

    */
    public static void printMenu(){
        System.out.println("welcome to GOFO :D\n");
        System.out.println("[1] log in");
        System.out.println("[2] sign up\n");
        System.out.println("[3] want to own a playground ?\n");

        System.out.println("enter choose :");

    }
}
