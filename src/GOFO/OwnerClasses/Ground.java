package GOFO.OwnerClasses;

import GOFO.DataModel.DataSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;

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
     public  boolean signUpOpeningTime(int opening){
        if(opening>=0 &&opening <24){
            this.openingTime= opening;
            return true;
        }
        return false;
     }

     public boolean signUpClosingTime(int closing){
        if(closing>=0 &&closing <24){
            if(closing>openingTime){
                closingTime = closing;
                return true;
            }
        }
        return false;
     }
    public boolean signUpPrice(int price) {
        if(price >0 && price <= 20){
            this.price = price;
            return  true;
        }
        return false;
    }

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
     public  void addBooking(Booking newBooking){
        bookings.add(newBooking);
     }
     public String getLastBookingID(){
        return bookings.get(bookings.size()-1).getID();

     }
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
