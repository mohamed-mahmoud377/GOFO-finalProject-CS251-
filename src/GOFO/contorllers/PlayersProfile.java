package GOFO.contorllers;

import GOFO.DataModel.DataSource;
import GOFO.OwnerClasses.Booking;
import GOFO.OwnerClasses.Ground;
import GOFO.PlayerClasses.Invitation;
import GOFO.PlayerClasses.Search;
import GOFO.PlayerClasses.Team;
import GOFO.Users.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * this class is a control class and because this program is a console based program so it just contain
 * a static methods that will be used in the main to keep the code more organized and will contain
 * all the methods that the Player will be able to preform .
 * @author mohamed mahmoud
 */
public class PlayersProfile {
    private  PlayersProfile(){}

    /**
     * prints all menu for the player to choose from whatever he want to do
     * @param currentPlayer the player who recently logged in or signed up
     */
    public static void printMenu( Player currentPlayer){

        System.out.println("welcome back " + currentPlayer.getName() + "\n");
        System.out.println("[1] Manage booking");
        System.out.println("[2] Manage teams");
        System.out.println("[3] Mange invitations");
        System.out.println("[4] Update INFO");
        System.out.println("[5] log out");

    }

    /**
     * static method allow the player to interact with the program to search for the playgrounds he wants
     * and can book any one of them and can view them
     * @param currentPlayer the player who recently logged in or signed up
     */
    public static void mangeBooking (Player currentPlayer){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String string_input;
        int int_input = 0;

        while(true){
            System.out.println("[1]Search Playground ");
            System.out.println("[2] view my bookings");
            System.out.println("[3] back");
            try{
                int_input=scanner1.nextInt();
                if(int_input==1){
                    while(true) {
                        System.out.println("[1] view all grounds ");
                        System.out.println("[2] search by specific range of date and time ");
                        System.out.println("[3] search by rance price ");
                        System.out.println("[3] search by specific owner name");
                        System.out.println("[4] search by specific Playground name ");
                        System.out.println("[5] back");
                        try {
                            int_input = scanner1.nextInt();
                            if(int_input==1) {
                                while (true) {
                                    try {
                                        System.out.println("these are the available playGrounds");
                                        List<Ground> availableGrounds = Search.ViewAllGrounds();
                                        for (Ground i : availableGrounds) {
                                            i.display();
                                            System.out.println("\n\n");
                                        }
                                        System.out.println("do want to book a play ground ? (y/n)");
                                        string_input = scanner.nextLine();
                                        if (string_input.equals("y") || string_input.equals("Y")) {
                                            System.out.println("enter the ID of the play ground ");
                                            string_input = scanner.nextLine();
                                            for (Ground i : availableGrounds) {
                                                if (i.getID().equals(string_input)) {
                                                    System.out.println("what time do want to start playing at in  24 hours format ");
                                                    int_input = scanner1.nextInt();
                                                    int startingTime= int_input;
                                                    System.out.println("hat time do want to end the match at in  24 hours format");
                                                    int_input = scanner1.nextInt();
                                                    int endingTime = int_input;

                                                    while (!i.book(startingTime,endingTime,currentPlayer.getID())) {
                                                        System.out.println("the time you entered is wrong or taken try again");
                                                        System.out.println("what time do want to start playing at in  24 hours format ");
                                                        startingTime= scanner1.nextInt();
                                                        System.out.println("hat time do want to end the match at in  24 hours format");
                                                        endingTime= scanner1.nextInt();
                                                    }
                                                    System.out.println("you has booked the playground successfully");
                                                    currentPlayer.addBookingID(i.getLastBookingID());
                                                    break;

                                                }
                                                break;
                                            }

                                        } else
                                            break;
                                    }catch (InputMismatchException e){
                                        scanner.nextLine();
                                        scanner1.nextLine();
                                        System.out.println("please enter an integer value");
                                    }
                                }

                            }else if(int_input==2){
                                while(true) {
                                    try {
                                        System.out.println("enter the starting time of the date you want to search with :");
                                        int start = scanner1.nextInt();
                                        System.out.println("enter the ending time");
                                        int end = scanner1.nextInt();
                                        while (end <= start) {
                                            System.out.println("the input you just gave is not right try again");
                                            System.out.println("enter the starting time of the date you want to search with :");
                                            start = scanner1.nextInt();
                                            System.out.println("enter the ending time");
                                            end = scanner1.nextInt();

                                        }
                                        List<Ground> grounds = Search.searchBySpecificRangeOfDateAndTime(start, end);
                                        if (!grounds.isEmpty()) {
                                            System.out.println("the aviliable play grounds in this time are :");
                                            for (Ground i : grounds) {
                                                i.display();
                                                System.out.println("\n");
                                            }

                                        } else {
                                            System.out.println("there is not availible playgrounds int the given time ");
                                            System.out.println("[0] back");
                                            string_input = scanner.nextLine();
                                            break;
                                        }
                                        System.out.println("do want to book a play ground ? (y/n)");
                                        string_input = scanner.nextLine();
                                        if (string_input.equals("y") || string_input.equals("Y")) {
                                            System.out.println("enter the ID of the play ground ");
                                            string_input = scanner.nextLine();
                                            for (Ground i : grounds) {
                                                if (i.getID().equals(string_input)) {
                                                    System.out.println("what time do want to start playing at in  24 hours format ");
                                                    int_input = scanner1.nextInt();
                                                    int startingTime= int_input;
                                                    System.out.println("hat time do want to end the match at in  24 hours format");
                                                    int_input = scanner1.nextInt();
                                                    int endingTime = int_input;

                                                    while (!i.book(startingTime,endingTime,currentPlayer.getID())) {
                                                        System.out.println("the time you entered is wrong or taken try again");
                                                        System.out.println("what time do want to start playing at in  24 hours format ");
                                                        startingTime= scanner1.nextInt();
                                                        System.out.println("hat time do want to end the match at in  24 hours format");
                                                        endingTime= scanner1.nextInt();
                                                    }
                                                    System.out.println("you has booked the playground successfully");
                                                    currentPlayer.addBookingID(i.getLastBookingID());
                                                    break;

                                                }
                                                break;
                                            }

                                        } else
                                            break;
                                    }catch (InputMismatchException e){
                                        System.out.println("you should have entered a int value");
                                    }
                                }
                            }else if(int_input==3){

                            }else if(int_input==4){

                            }else if(int_input==5){
                                break;

                            }else {
                                System.out.println("you entered a wrong input");

                            }



                        } catch (InputMismatchException e) {
                            System.out.println("sorry you entered a wrong input  \n");
                            scanner1.nextLine();
                        }

                    }

                }else if(int_input==2){
                    while(true){
                        if(!currentPlayer.getBookingsID().isEmpty()){
                            List<Booking> bookings= currentPlayer.getMyBookings();
                            for(Booking i: bookings){
                                i.displayForPlayer();
                                System.out.println("\n");
                            }
                            System.out.println("[0] back");
                            string_input =scanner.nextLine();
                            break;




                        }else {
                            System.out.println("you dont have any bookings");
                        }
                    }


                }else if(int_input==3){
                    break;

                }else {
                    System.out.println("you entered a wrong value");
                }

            }catch (InputMismatchException e){
                System.out.println("please enter an integer value");
                scanner.nextLine();
                scanner1.nextLine();
            }
        }

    }

    /**
     * static method allow the user to mange every thing about his team and the teams he joined
     * @param currentPlayer the player who recently logged in or signed up
     */
    public static void mangeTeams(Player currentPlayer){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String string_input;
        int int_input = 0;
        while(true) {
            try {

                System.out.println("[1] create team");
                System.out.println("[2] my team");
                System.out.println("[3] my joined teams");
                System.out.println("[4] back");
                int_input = scanner1.nextInt();
                if (int_input == 1){
                    if(currentPlayer.getMyTeamID().equals("none")) {
                        Team currentTeam = new Team();

                        System.out.println("enter team ID it (must be unique one) :  ");
                        string_input = scanner.nextLine();
                        while (!currentTeam.signUpID(string_input)) {
                            System.out.println("the ID you entered is not valid or maybe taken");
                            string_input = scanner.nextLine();

                        }
                        System.out.println("accepted \n Team ID is : " + string_input);
                        String TeamID = string_input;
                        //setting the  ID player for the team
                        currentTeam.setTeamLeaderID(currentPlayer.getID());
                        // adding the to data base
                        currentPlayer.addMyTeam(currentTeam);
                        System.out.println("Team created successfully");
                        System.out.println("you can go to mange invitations and invite your friends");
//                        DataSource.getInstance().printTeams();


                    }else{
                        System.out.println("you already created your team");
                    }

                }else if(int_input==2){

                    if(currentPlayer.getMyTeam()==null) {
                        System.out.println("you Dont have any Team");
                        continue;
                    }

                    currentPlayer.getMyTeam().display();
                    System.out.println("\n\n [0] back");
                    string_input=scanner.nextLine();
                    break;


                }else if(int_input==3){

                    List<String> joinedTeamsIDs = currentPlayer.getJoinedTeamsIDs();
                    if(!joinedTeamsIDs.isEmpty()) {
                        System.out.println(" Teams you join  :");


                        for (String i : joinedTeamsIDs) {
                            DataSource.getInstance().getTeamByID(i).display();
                        }

                        System.out.println("[0] back");
                        string_input = scanner.nextLine();


                    }else
                        System.out.println("you did not join any team");
                }else if(int_input==4){

                    break;

                } else{
                    System.out.println("you entered wrong input");
                }
            }catch (InputMismatchException e){
                System.out.println("sorry you entered a wrong input  \n");
                scanner1.nextLine();

            }
        }
    }

    /**
     * static method for the player to interact with the system that allow him the mange his invitations
     * so he can send an invitation or accept one or maybe reject it
     * @param currentPlayer the player who recently logged in or signed up
     */
    public static void mangeInvitations(Player currentPlayer){
        while(true) {

            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            String string_input;
            int int_input = 0;
            try {

                System.out.println("[1]send invitation to other player to join your team");
                System.out.println("[2] view sent invitation");
                System.out.println("[3] back");

                int_input = scanner1.nextInt();
                if (int_input == 1) {
                   if(!currentPlayer.getMyTeamID().equals("none")) {
                       Invitation newInvitation = new Invitation();
                       newInvitation.setSenderID(currentPlayer.getID());
                       newInvitation.setTeamInvitedID(currentPlayer.getMyTeam().getID());
                       while (true) {
                           System.out.println("enter the Player's ID you want to invite");
                           string_input = scanner.nextLine();
                           while (!newInvitation.checkReceiverID(string_input)) {
                               System.out.println("the ID you entered is not right try again");
                               string_input = scanner.nextLine();

                           }
                           newInvitation.addReceiver(string_input);
                           System.out.println("sent anther invitation? (y/n)");
                           string_input = scanner.nextLine();
                           if (string_input.equals("y") || string_input.equals("Y"))
                               continue;
                           System.out.println("enter the massage attached by the invitation :");
                           string_input = scanner.nextLine();
                           newInvitation.setMassage(string_input);
                           currentPlayer.sendInvitation(newInvitation);

                           break;
                       }
                   }else
                       System.out.println("sorry you did not create any team");
                            break;

                } else if (int_input == 2) {
                    ArrayList<Invitation> sentInvitations = currentPlayer.receiveInvitations();
                    if(!sentInvitations.isEmpty()) {
                        for (Invitation i : sentInvitations) {

                            i.display();
                            System.out.println("\n");
                        }while(true) {
                            int check1=0;
                            System.out.println("enter the invitation ID you the team you want to join");
                            string_input = scanner.nextLine();
                            for (Invitation i : sentInvitations) {
                                if (string_input.equals(i.getID())) {
                                    //adding the team ID to the player
                                    currentPlayer.addJoinedTeam(i.getTeamInvitedID());
                                    //getting the team it self from the data scource and and add the player ID to the joined players
                                    DataSource.getInstance().getTeamByID(i.getTeamInvitedID()).addInvitedPlayer(currentPlayer.getID());
                                    System.out.println("you have been added to  " + i.getTeamInvitedID() +" team");
                                    i.deleteReceiverByItsID(currentPlayer.getID());

                                    check1=1;
                                    break;
                                } else {
                                    System.out.println("you entered a wrong ID try again");
                                }

                            }
                            if(check1==1)
                            break;
                        }


                    }else {
                        System.out.println("you don't have any invitations yet");
                    }
                }else if (int_input==3){
                    break;
                }


            } catch (InputMismatchException e) {
                System.out.println("sorry you entered a wrong input  \n");
                scanner1.nextLine();


            }
        }



    }

    /**
     * allow the user to update his name or email or his password
     * @param currentPlayer the player who recently logged in or signed up
     */
    public static void updateInfo(Player currentPlayer){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String string_input;
        int int_input = 0;
        while(true) {
            try {
                System.out.println("your current ID is : " + currentPlayer.getID());

                System.out.println("your current name is : " + currentPlayer.getName());
                System.out.println("your Current Email is : " + currentPlayer.getEmail() + "\n");

                System.out.println("your ID can not be updated .\n");

                System.out.println("[1] change name ");
                System.out.println("[2] change Email");
                System.out.println("[3] change password");
                System.out.println("[4] back");
                int_input = scanner1.nextInt();
                if(int_input==1){
                    System.out.println("enter the new name :");
                    string_input= scanner.nextLine();
                    while (!currentPlayer.signUp_name(string_input)){
                        System.out.println("the name you entered is not valid ");
                        string_input= scanner.nextLine();
                    }

                    System.out.println("name changed successfully");

                }else if(int_input==2){
                    System.out.println("enter you new email");
                    string_input= scanner.nextLine();
                    while (!currentPlayer.signUp_Email(string_input)){
                        System.out.println("the email you entered is not valid ");
                        string_input= scanner.nextLine();

                    }
                    System.out.println("Email changed successfully");

                }else if(int_input==3){
                    System.out.println("enter you last password : ");
                    string_input=scanner.nextLine();
                    while(!string_input.equals(currentPlayer.getPassWord())){
                        System.out.println("the password you entered is wrong try again ");
                        string_input=scanner.nextLine();

                    }
                    System.out.println("enter your new passWord :");
                    string_input = scanner.nextLine();
                    while(!currentPlayer.signUp_password(string_input)){
                        System.out.println("this password is not valid ");
                        string_input =scanner.nextLine();
                    }

                }else if(int_input==4){
                    break;

                }else
                    System.out.println("wrong input");
            }catch (InputMismatchException e){
                System.out.println("enter a integer value");
                scanner1.nextLine();
            }
        }



    }


}
