package GOFO.contorllers;

import GOFO.OwnerClasses.Ground;
import GOFO.Users.Owner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OwnerProfile {
    private OwnerProfile(){ }
    public static void printMenu(Owner currentOwner){

        System.out.println(" welcome "+ currentOwner.getName()+"\n");

        System.out.println("[1] View my PlayGrounds");
        System.out.println("[2] Add New PlayGround");
        System.out.println("[3] Modify PlayGrounds ");
        System.out.println("[4] Update info");
        System.out.println("[5] Log out");
    }

    public static void AddNewPlayGround(Owner currentOwner){
        String string_input;
        int int_input = 0;
        Ground newGround = new Ground();
        newGround.setOwnerID(currentOwner.getID());
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        try {
            System.out.println("enter Playground ID : (must be a unique)");
            string_input = scanner.nextLine();
            while (!newGround.signUpID(string_input)) {
                System.out.println("the ID you entered is not valid or maybe taken");
                string_input = scanner.nextLine();

            }
            System.out.println("accepted \n your ID is : " + string_input);
            String GroundID = string_input;
            System.out.println("enter PlayGround name");
            string_input = scanner.nextLine();

            while (!newGround.signUpName(string_input)) {
                //while get into this loop if the user entered a wrong user name
                //only char works
                System.out.println("the name entered is not valid only english char works");
                string_input = scanner.nextLine();

            }
            String playerFullName = string_input;
            System.out.println("enter Playground address : ");
            string_input = scanner.nextLine();
            newGround.setAddress(string_input);

            System.out.println("enter playground description :");
            string_input = scanner.nextLine();
            newGround.setDescription(string_input);
            try {
                System.out.println("enter the opening time of the playground :");
                int_input = scanner1.nextInt();
                while (!newGround.signUpOpeningTime(int_input)){
                    System.out.println("the time you entered is not valid it must be between  ( 0 to 24 )");
                   int_input = scanner.nextInt();

                }
                System.out.println("enter the closing time of the playground :");
                while (!newGround.signUpClosingTime(int_input)) {
                    System.out.println("the time you entered is not valid it must be between  ( 0 to 24 ) and after the opening time");
                    int_input = scanner.nextInt();
                }
                // adding the playground to the array in the Owner
                currentOwner.addNewPlayGround(newGround);
                System.out.println("the Playground has added successfully");

            }catch (InputMismatchException e){
                System.out.println("you entered an a string value and it has to be integer ");
                    scanner1.nextLine();
            }

        }catch (InputMismatchException e){
            System.out.println("you entered an a string value and it has to be inter ");
        }

    }

    public static void viewPlayGrounds(Owner currentOwner){


    }
}
