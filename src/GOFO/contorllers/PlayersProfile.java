package GOFO.contorllers;

import GOFO.DataModel.DataSource;
import GOFO.PlayerClasses.Invitation;
import GOFO.PlayerClasses.Team;
import GOFO.Users.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PlayersProfile {
    private  PlayersProfile(){}


    public static void printMenu( Player currentPlayer){

        System.out.println("welcome back " + currentPlayer.getName() + "\n");
        System.out.println("[1] Manage booking");
        System.out.println("[2] Manage teams");
        System.out.println("[3] Mange invitations");
        System.out.println("[4] Update INFO");
        System.out.println("[5] log out");

    }

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
                    if(currentPlayer.getMyTeamID()=="none") {
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
                        DataSource.getInstance().printTeams();


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

    public static void mangeBooking (){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String string_input;
        int int_input = 0;
        System.out.println("[1]Search Playground ");
        System.out.println("[2] view my bookings");
        System.out.println("[3] back");
        while(true){
            System.out.println("[1]Search Playground ");
            System.out.println("[2] view my bookings");
            System.out.println("[3] back");
            try{
                int_input=scanner1.nextInt();
                if(int_input==1){


                }else if(int_input==2){

                }else if(int_input==3){

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


}
