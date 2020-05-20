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


                }else if(int_input==2){

                }else if(int_input==3){

                }else{
                    System.out.println("you entred worng input");
                }
            }catch (InputMismatchException e){
                System.out.println("sorry you entered a wrong input  \n");
                scanner1.nextLine();

            }
        }
    }
}
