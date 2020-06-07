package GOFO.OwnerClasses;

import GOFO.DataModel.DataSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;

/**
 * this class has all the info needed about any playground and it is only exist in the Owner class
 * @author mohamed mahmoud
 */
public class Ground {

    private String ID;
    private String name;
    private String description;
    private String address;
    private String OwnerID;
    private int openingTime;
    private int closingTime;
    private int price ;
    private List<Booking> bookings;
    private boolean isSuspended;

    public Ground(String ID, String name, String description, String address, int openingTime, int closingTime, int price, List<Booking> bookings, boolean isSuspended) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        price = price;
        this.bookings = bookings;
        this.isSuspended = isSuspended;
    }

    public Ground(String ID, String name, String description, String address, int price, List<Booking> bookings, boolean isSuspended) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.address = address;
        price = price;
        this.bookings = bookings;
        this.isSuspended = isSuspended;
    }

    public Ground(String ID, String name, String description, String address, String ownerID, int openingTime, int closingTime, int price, boolean isSuspended) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.address = address;
        OwnerID = ownerID;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.price = price;
        this.isSuspended = isSuspended;
        bookings = new ArrayList<Booking>();
    }
    public Ground(){
        this.ID = "none";
        this.name ="none";
        this.description = "none";
        this.address = "none";
        this.OwnerID = "none";
        price = 0;
        this.bookings = new ArrayList<Booking>();
        this.isSuspended = false;
        this.openingTime = -1;
        this.closingTime = -1;

    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String ownerID) {
        OwnerID = ownerID;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    /**
     * checks if the ID exist in the date source or not and if it there so it is not valid and return false
     * and if it not there will return true
     * @param ID the ID of the playGround
     * @return true of the ID is valid and does not exist in the data source and false if the opposite
     */
    public boolean signUpID(String ID){
        if( DataSource.getInstance().checkPlayGroundIDIfValid(ID)) {
            for (int i = 0; i < ID.length(); i++) {
                char a = ID.charAt(i);
                if (!isDefined(a) || isWhitespace(a)) {
                    return false;
                }
            }
        }else {
            return false;
        }
        this.ID = ID;
        return true;

         }

    /**
     * check to see if the name is valid or not
     * @param name The name entered by the user
     * @return true if the name is correct
     */
    public boolean signUpName(String name){
         name = name.trim();
         for(int i=0;i<name.length();i++){
             char a = name.charAt(i);
             if(!isLetter(a) &&!isWhitespace(a)){
                 return false;
             }

         }
         this.name = name;
         return true;
     }

    /**
     * checks if the opening time is in the valid range between 0 and 24
     * @param opening the opening time entered by the Owner
     * @return True of the opening time is valid
     */
     public  boolean signUpOpeningTime(int opening){
        if(opening>=0 &&opening <24){
            this.openingTime= opening;
            return true;
        }
        return false;
     }
    /**
     * checks if the closing time is in the valid range between 0 and 24
     * @param closing the closing time entered by the Owner
     * @return True of the closing time is valid
     */
     public boolean signUpClosingTime(int closing){
        if(closing>=0 &&closing <24){
            if(closing>openingTime){
                closingTime = closing;
                return true;
            }
        }
        return false;
     }

    /**
     * check is the price is valid or not it should be more than 0 and less than 20$
     * @param price the price entered by the Owner
     * @return return true of the price is valid and false if not
     */
    public boolean signUpPrice(int price) {
        if(price >0 && price <= 20){
            this.price = price;
            return  true;
        }
        return false;
    }

    /**
     * this method checks if the given start time and the end time is valid that it is not taken or out
     * of the starting and ending time and if all the giving info is true it will create a Booking object
     * and add to list of bookings
     * @param start the starting time entered by the Player
     * @param end the ending time entered by the Player
     * @param playerID the ID of the player that is going to booking this playground
     * @return return true of the gavin info is true and false if not
     */
     public boolean book(int start ,int end,String playerID){
        boolean s =true ;
        boolean n =true;
        int d = end -start;
                if(!(start>=0 &&start <24))
                    return false;
             if(!(end>=0 &&end <24))
                 return false;
               if(end<=start)
                   return false;


                for(Booking i:bookings){
                    for(int w= start ;w<=end;w++){
                       if(i.getStartingDate()==w){
                           s= i.getStartingDate() == end;
                       }
                       if(i.getEndingDate()==w){
                           n =i.getEndingDate()==start;
                       }

                    }


        }
                if(s &&n){
                    Booking newBooking = new Booking();
                    newBooking.setStartingDate(start);
                    newBooking.setEndingDate(end);
                    newBooking.setDuration();
                    newBooking.setPlayerID(playerID);
                    newBooking.setOwnerID(OwnerID);
                    newBooking.setPlayGroundID(ID);
                    newBooking.setPlaygroundName(name);
                    bookings.add(newBooking);

                }



     return s &&n;
     }

    /**
     * displays all the info need for the playground and all of its bookings
     */
    public void display(){

         System.out.println("Name : " + name +"    owner : " +OwnerID);
         System.out.println("status : " +(isSuspended ?"suspended" :"not suspended"));
         System.out.println(" ID :" + ID);
         System.out.println(" Address : "+ address);
         System.out.println("Price : " + price);
         System.out.println("Opening time :" +openingTime+"        Closing time : "+ closingTime);

         System.out.println("taken bookings times : ");
         for(Booking i : bookings){
             i.displayForGround();
         }
     }

    /**
     * add a brand new booking to the bookings list
     * @param newBooking the new create book
     */
     public  void addBooking(Booking newBooking){
        bookings.add(newBooking);
     }

    /**
     * gets the last booking ID
     * @return a string of the last booking ID
     */
     public String getLastBookingID(){
        return bookings.get(bookings.size()-1).getID();

     }
    /**
     * this method checks if the given start time and the end time is valid that it is not taken or out
     * of the starting and ending time
     * @param start the starting time entered by the Player
     * @param end the ending time entered by the Player
     * @return return true of the gavin info is true and false if not
     */
     public boolean checkBooking(int start , int end){
         boolean s =true ;
         boolean n =true;
         int d = end -start;
         if(!(start>=0 &&start <24))
             return false;
         if(!(end>=0 &&end <24))
             return false;
         if(end<=start)
             return false;

         for(Booking i:bookings){
             for(int w= start ;w<=end;w++){
                 if(i.getStartingDate()==w){
                     s= i.getStartingDate() == end;
                 }
                 if(i.getEndingDate()==w){
                     n =i.getEndingDate()==start;
                 }

             }


         }
         return s &&n;

     }

}
