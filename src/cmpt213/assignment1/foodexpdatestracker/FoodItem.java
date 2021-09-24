package cmpt213.assignment1.foodexpdatestracker;


import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * FoodItem class
 * Stores fields name, notes, price, expiration date, days until expiry, and expiration status
 * FoodItem objects are stored in an ArrayList in Main
 */
public class FoodItem {

    //store attributes for name, notes, price, expiry date
    //  name and notes may contain spaces
    //  name cannot be empty, notes can
    private String name;
    private String notes;
    private double price;
    private LocalDateTime expDate;
    private int daysUntilExp;
    private boolean isExpired;

    /**
     * FoodItem constructor; requires information about the object
     *
     * @param name the name of the food item; cannot be empty
     * @param notes any other information; can be empty
     * @param price the price of this item
     * @param expDate the expiration date of this item
     */
    public FoodItem(String name, String notes, double price, LocalDateTime expDate) {

        //name cannot be empty; enforce with exception
        if (name.equals("")) {
            throw new IllegalArgumentException("Name of food cannot be empty.");
        }

        this.name = name;
        this.notes = notes;
        this.price = price;
        this.expDate = expDate;

        //update time until expiry upon construction
        //FIX LATER, DOES NOT ACCOUNT FOR TIME BETWEEN MONTHS AND YEARS
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(expDate)) {
            isExpired = false;
            Period period = Period.between(currentTime.toLocalDate(), expDate.toLocalDate());
            this.daysUntilExp = period.getDays();
        }
        else {
            this.isExpired = true;
            this.daysUntilExp = -1;
        }
    }

    /**
     * getter for expiration date; used for date comparison
     * @return the expiration date
     */
    public LocalDateTime getExpDate() {
        return expDate;
    }

    /**
     * getter for the name of the item
     * @return the name of the item
     */
    public String getName() {return name;}

    /**
     * determines if a particular item is expired
     * @return the expiration status
     */
    public boolean isExpired() {return isExpired;}

    /**
     * getter for the days until expiration
     * @return the number of days until expiration
     */
    public int getDaysUntilExp() {return daysUntilExp;}

    /**
     * constructs a string with all information about this FoodItem
     * @return the string containing all relevant information
     */
    @Override
    public String toString() {
        String foodString = "";
        foodString += "Food: " + name;
        foodString += "\nNotes: " + notes;
        foodString += "\nPrice: " + price;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        foodString += "\nExpiry date: " + expDate.format(formatter);

        //update time until expiry every time the food is displayed
        //FIX LATER, DOES NOT ACCOUNT FOR TIME BETWEEN MONTHS AND YEARS
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(expDate)) {
            isExpired = false;
            Period period = Period.between(currentTime.toLocalDate(), expDate.toLocalDate());
            int daysUntilExpiry = period.getDays();
            this.daysUntilExp = daysUntilExpiry;
            if (daysUntilExpiry == 0) {
                foodString += "\nThis food item will expire today.";
            }
            else {
                foodString += "\nThis food will expire in " + daysUntilExpiry + " day(s).";
            }
        }
        else {
            this.isExpired = true;
            this.daysUntilExp = -1;
            foodString += "\nThis food is already expired!";
        }

        return foodString;
    }

}
