/*
Sam Melero
CS-119
final Project
12/7/17
 */
package finalproject;

import java.text.DecimalFormat;
import java.util.*;
/**
 *
 * @author samme
 */

class myUtils {

    public static String formatNum(float value, String fmt){ 
        String result = " ";
        DecimalFormat df = new DecimalFormat(fmt);
        result = df.format(value);
        return result;
    } // end foramtNum 

    public static Boolean isInteger(String s){
        try
        {
            int val = Integer.parseInt(s);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public static int tryParseInt(String s, int defaultVal){ 
    try{    
        return Integer.parseInt(s);
    }
    catch(Exception ex){
        return defaultVal;  
    }
    }

    public static int findItem(String values[], String value){
        int idx = -1;
        int i = 0;

        while (i < values.length && idx < 0){
            if (value.equalsIgnoreCase(values[i]) ) {
                idx = i;
            }
            i++;
        }
        return idx;
    }

    public static int findItem(int values[], int value){
        int idx = -1;
        int i = 0;

        while (i < values.length && idx < 0){
            if (value == values[i])
                idx = i;
            i++;
        }
        return idx;
    }

 }

class InvalidCabinCodeException extends Exception{
    public InvalidCabinCodeException (String message){
        super(message);
    }
}

class MaxPassengersExcededException extends Exception{
    public MaxPassengersExcededException (String message){
        super(message);
    }
}

class Person extends Object implements Comparable <Person>{
    String lastName;
    String address;
    final int MAX_PASSENGERS = 5;
    //mutators
    public void setLastName(String last){
        this.lastName = last;
    }
    public void setAddress(String adi){
        this.address = adi;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    public String getAddress(){
        return this.address;
    }
    
    //constructors
    public Person(String last, String adi){
        this.lastName = last;
        this.address = adi;
    }
    public Person(){
        this.lastName = " ";
        this.address = " ";
    }
    
    //compareTo method
    @Override
    public int compareTo(Person person){  
      String lastName = person.getLastName();
      return this.getLastName().compareToIgnoreCase(lastName);    
              
    }
    //end compareTo
    
    public String toString(){
        return "Last Name: " + lastName + " Address: " + address; 
    }
    
}

class Passenger extends Person{
    int cabinCode;
    int numberPassengers;
    String cabinType;
    double cabinFare;
    
    //mutators
    public void setCabinCode(int code)throws InvalidCabinCodeException{
        if (code < 1 || code > 5){
            throw new InvalidCabinCodeException("Not valid");
        }
        else
            this.cabinCode = code;
       
        }
    public void setNumberPassengers(int number){
        this.numberPassengers = number;
    }
    public int getCabinCode(){
        return this.cabinCode;
    }
    public int getNumberPassengers(){
        return this.numberPassengers;
    }
    
    //Constructors
    public Passenger(String last, String adi, int code, int number) throws InvalidCabinCodeException, MaxPassengersExcededException{
        super(last, adi);
       
        if(code < 1 || code >5){
           throw new InvalidCabinCodeException("Not valid");
        }
        else
        this.cabinCode = code;
        
        if(number > MAX_PASSENGERS ){
            throw new MaxPassengersExcededException("Not valid");
        }
        else
        this.numberPassengers = number;
    }
    
    public Passenger(String last, String adi)throws InvalidCabinCodeException, MaxPassengersExcededException{
        this(last, adi, 0, 0);
    }
    
    public Passenger()throws InvalidCabinCodeException, MaxPassengersExcededException{
        this(" ", " ", 0, 0);
    }
    
    public String getTicketInfo(){
        String outString;
        int code = this.cabinCode;
                switch (code){
           case 1:
               cabinType = "Interior";
               cabinFare = 650;
               break;
           case 2:
               cabinType = "OceanView";
               cabinFare = 1000;
               break;
           case 3:
               cabinType = "Balcony";
               cabinFare = 1500;
               break;
           case 4:
               cabinType = "Suite";
               cabinFare = 2500;
               break;
           case 5:
               cabinType = "Deluxe Suite";
               cabinFare = 3000;
               break;
        }
       
        double fare;
        fare = cabinFare * numberPassengers;
        outString = super.toString() + String.format(" Total people: %d Cabin Type: %s Total: $%.sf ", numberPassengers, cabinType, fare);
        return outString;
    }
}

/**
 *
 * @author samme
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    CruiseForm FinalProject = new CruiseForm();
    FinalProject.setVisible(true);
    
    }
    
    

}
