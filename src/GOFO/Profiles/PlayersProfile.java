package GOFO.Profiles;

import GOFO.DataModel.DataSource;
import GOFO.OwnersData.Team;
import GOFO.Users.Player;
import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayersProfile {
    public static void MangeTeams(Player currentPlayer){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String string_input;
        int int_input = 0;
        while(true) {
            try {


                System.out.println("[1] create team");
                System.out.println("[2] my teams");
                System.out.println("[3] my joined teams");
                int_input = scanner1.nextInt();
                if (int_input == 1){
                    Team currentTeam = new Team();
                    System.out.println("enter team ID");
                    System.out.println("enter team ID it (must be unique one) :  ");
                    string_input= scanner.nextLine();
                    while(!currentTeam.signUpID(string_input)){
                        System.out.println("the ID you entered is not valid or maybe taken");
                        string_input=scanner.nextLine();

                    }
                    System.out.println("accepted \n Team ID is : " + string_input);
                    String TeamID= string_input;
                    //setting the  ID player for the team
                    currentTeam.setTeamLeaderID(currentPlayer.getID());
                    // adding the to data base
                    currentPlayer.addMyTeam(currentTeam);
                    System.out.println("Team created successfully");
                    DataSource.getInstance().printTeams();

                    //code for adding playing by inviting them well be added after coding the invitation class




                }else if(int_input==2){

                }else if(int_input==3){

                }else{
                    System.out.println("you entered wrong input");
                }
            }catch (InputMismatchException e){
                System.out.println("sorry you entered a wrong input  \n");
                scanner1.nextLine();

            }
        }
    }
}
