package GOFO.OwnerClasses;

import GOFO.DataModel.DataSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;

public class Ground {

    String ID;
    String name;
    String description;
    String address;
    String OwnerID;
    int openingTime;
    int closingTime;
    int Price ;
    List<Booking> bookings;
    boolean isSuspended;

    public Ground(String ID, String name, String description, String address, int openingTime, int closingTime, int price, List<Booking> bookings, boolean isSuspended) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        Price = price;
        this.bookings = bookings;
        this.isSuspended = isSuspended;
    }

    public Ground(String ID, String name, String description, String address, int price, List<Booking> bookings, boolean isSuspended) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.address = address;
        Price = price;
        this.bookings = bookings;
        this.isSuspended = isSuspended;
    }
    public Ground(){
        this.ID = "none";
        this.name ="none";
        this.description = "none";
        this.address = "none";
        this.OwnerID = "none";
        Price = 0;
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
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
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
        if(opening>=0 &&opening <=24){
            this.openingTime= opening;
            return true;
        }
        return false;
     }

     public boolean signUpClosingTime(int closing){
        if(closing>=0 &&closing <=24){
            if(closing>openingTime){
                closingTime = closing;
                return true;
            }
        }
        return false;
     }

     public boolean book(){

     }
}
