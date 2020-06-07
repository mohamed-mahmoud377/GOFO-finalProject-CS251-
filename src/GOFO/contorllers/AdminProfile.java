package GOFO.contorllers;

import GOFO.DataModel.DataSource;
import GOFO.OwnerClasses.Ground;
import GOFO.Users.Owner;
import org.w3c.dom.ls.LSOutput;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class is a control class and because this program is a console based program so it just contain
 * a static methods that will be used in the main to keep the code more organized and will contain
 * all the methods the the Admin will be able to preform .
 * @author mohamed mahmoud
 *
 *
 */
public class AdminProfile {
    /**
     *this class has a private constructor because it a utility class
     */
    private AdminProfile(){}

   public  static void displayMenu(){
       System.out.println("[1] suspend playGrounds");
       System.out.println("[2] active playgrounds");
       System.out.println("[3] delete playground");
       System.out.println("[4] log out");
   }
    /**
     *this method get all the play ground that is active and print it to the admin
     * so he can suspend any playground he wants by entering its ID
     *
     */
   public static  void suspendPlayGrounds() {
        int check=0;
       Scanner scanner = new Scanner(System.in);
       Scanner scanner1 = new Scanner(System.in);



       String string_input;
       List<Owner> owners = DataSource.getInstance().getOwners();
       List<Ground> aLLGrounds = new ArrayList<>();
       for (Owner i : owners) {
           for (Ground w : i.getPlaygrounds()) {
               if (!w.isSuspended()) {
                   w.display();
                   System.out.println("\n");
                   aLLGrounds.add(w);
               }
           }


       }
       while (true) {
           System.out.println("enter the ID of the playGround that you want to suspend");
           string_input=scanner.nextLine();

           for (Ground i : aLLGrounds) {
               if (i.getID().equals(string_input)){
                   i.setSuspended(true);
                   System.out.println("the the Ground has been suspended successfully");
                   check=1;
                   break;
               }
           }
           if(check==1){
               check=0;
               break;
           }else{
               System.out.println("you entered a wrong ID ");
           }


       }
   }/**
     *this method get all the play ground that is suspended and print it to the admin
     * so he can active any playground he wants by entering its ID
     */
   public static void activePlayGround(){
       int check=0;
       Scanner scanner = new Scanner(System.in);
       Scanner scanner1 = new Scanner(System.in);



       String string_input;
       List<Owner> owners = DataSource.getInstance().getOwners();
       List<Ground> aLLGrounds = new ArrayList<>();
       for (Owner i : owners) {
           for (Ground w : i.getPlaygrounds()) {
               if (w.isSuspended()) {
                   w.display();
                   System.out.println("\n");
                   aLLGrounds.add(w);
               }
           }


       }
       while (true) {
           System.out.println("enter the ID of the playGround that you want to activate");
           string_input = scanner.nextLine();

           for (Ground i : aLLGrounds) {
               if (i.getID().equals(string_input)) {
                   i.setSuspended(false);
                   System.out.println("the the Ground has been activated successfully");
                   check = 1;
                   break;
               }
           }
           if (check == 1) {
               check=0;
               break;
           } else {
               System.out.println("you entered a wrong ID ");
           }


       }

   }
    /**
     *this static method get all the play ground that is available and print it to the admin
     * so he can delete any playground he wants by entering its ID
     */
   public static void deletePlayGround(){
       int check=0;
       Scanner scanner = new Scanner(System.in);
       Scanner scanner1 = new Scanner(System.in);



       String string_input;
       List<Owner> owners = DataSource.getInstance().getOwners();
       for (Owner i : owners) {
           for (Ground w : i.getPlaygrounds()) {
               if (w.isSuspended()) {
                   w.display();
                   System.out.println("\n");

               }
           }


       }
       while (true) {
           System.out.println("enter the ID of the playGround that you delete (note : the play ground has to be suspended fist to get deleted)");
           string_input = scanner.nextLine();
           Owner owner = null;
           Ground delGround = null;

           for (Owner i : owners) {
               for (Ground w : i.getPlaygrounds()) {
                   if (w.isSuspended()) {
                       if (w.getID().equals(string_input)) {
                           owner = i;
                           delGround = w;
//                           i.getPlaygrounds().remove(w);
                           System.out.println("the PlayGround has been deleted successfully ");
                           check = 1;
                           break;

                       }
                   }
               }

           }
           assert owner != null;
           List<Ground> grounds = owner.getPlaygrounds();
           grounds.remove(delGround);


           if (check == 1) {
               check = 0;
               break;
           } else {
               System.out.println("you entered a wrong ID ");
           }


       }

   }

}
