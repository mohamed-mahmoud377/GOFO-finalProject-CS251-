package GOFO;

import GOFO.DataModel.DataSource;
import GOFO.Users.Admin;
import GOFO.Users.PlayGroundOwner;
import GOFO.Users.Player;
import GOFO.verification.Verify;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataSource.getInstance().hard_coded_players();
            Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        String string_input;
            int int_input = 0;
            Player currentPlayer = null;
            PlayGroundOwner currentOwner = null;
            Admin admin = null;
            while(true) {
                while (true) {
                    try {
                        System.out.println("welcome to GOFO :D\n");
                        System.out.println("[1] log in");
                        System.out.println("[2] sing up\n");
                        System.out.println("[3] want to own a playground ?\n");

                        System.out.println("enter choose :");
                        int_input = scanner.nextInt();

                        if (int_input == 1) {

                        } else if (int_input == 2) {
                            currentPlayer = new Player();
                            scanner.nextLine();//clean the buffer
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



                        } else if (int_input == 3) {


                        } else {
                            System.out.println("please enter a valid integer input ");
                        }


                    } catch (InputMismatchException e) {
                        System.out.println("sorry you entered a wrong input  \n");
                        scanner.nextLine();

                    }
                }
            }
    }
}
