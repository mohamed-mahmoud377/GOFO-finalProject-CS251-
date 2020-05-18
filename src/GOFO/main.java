package GOFO;

import GOFO.Users.Admin;
import GOFO.Users.PlayGroundOwner;
import GOFO.Users.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String string_input;
            int int_input = 0;
            Player currentPlayer = null;
            PlayGroundOwner currentOwner = null;
            Admin admin = null;
            while(true) {
                while (true) {
                    try {
                        System.out.println("welcome to our PlayGround registration system :D\n");
                        System.out.println("[1] log in");
                        System.out.println("[2] sing up\n");
                        System.out.println("[3] want to own a playground ?\n");

                        System.out.println("enter choose :");
                        int_input = scanner.nextInt();

                        if (int_input == 1) {



                        } else if (int_input == 2) {


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
