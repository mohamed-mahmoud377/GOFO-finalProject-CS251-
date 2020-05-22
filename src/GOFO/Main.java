package GOFO;

import GOFO.contorllers.HomeScreen;
import GOFO.contorllers.OwnerProfile;
import GOFO.DataModel.DataSource;
import GOFO.contorllers.PlayersProfile;
import GOFO.Users.Admin;
import GOFO.Users.Owner;
import GOFO.Users.Player;
import GOFO.Users.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataSource.getInstance().hardCodedUsers();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        String string_input;
        int int_input = 0;
        Player currentPlayer = null;
        Owner currentOwner = null;
        User currentUser =null;
        Admin admin = null;
        while(true) {
            while (true) {
                try {
                   HomeScreen.printMenu();
                    int_input = scanner1.nextInt();
                    if (int_input==1){
                        currentUser = HomeScreen.userLogIn();
                        break;
                    } else if (int_input == 2) {
                        currentUser= HomeScreen.playerSigningUp();
                        break;
                    } else if (int_input == 3) {
                        currentUser = HomeScreen.ownerSigningUp();
                        break;
                    } else {
                        System.out.println("please enter a valid integer input ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("sorry you entered a wrong input  \n");
                    scanner1.nextLine();
                }
            }
            while(true){
                if(currentUser.getType().equals("Player")){
                    try {

                       PlayersProfile.printMenu((Player) currentUser);
                        int_input = scanner1.nextInt();
                        if (int_input == 1) {

                        } else if (int_input == 2) {
                            PlayersProfile.mangeTeams((Player) currentUser);
                        } else if (int_input == 3) {
                            PlayersProfile.mangeInvitations((Player) currentUser);
                        } else if(int_input==4){

                        }else if(int_input==5){
                            break;

                        }else{

                        }

                    }catch (InputMismatchException e) {
                        System.out.println("sorry you entered a wrong input  \n");
                        scanner1.nextLine();


                    }

                }else if(currentUser.getType().equals("Owner")){
                    OwnerProfile.printMenu((Owner) currentUser);
                    int_input = scanner1.nextInt();
                    if (int_input == 1) {

                    } else if (int_input == 2) {
                        OwnerProfile.AddNewPlayGround((Owner) currentUser);

                    } else if (int_input == 3) {

                    } else if(int_input==4){

                    }else if(int_input==5){
                        break;

                    }else{

                    }



                }else if(currentUser.getType().equals("Admin")){


                    System.out.println("this is admin profile ");
                    break;


                }

            }


        }
    }

}
