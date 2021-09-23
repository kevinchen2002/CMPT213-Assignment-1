package cmpt213.assignment1.foodexpdatestracker;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FoodItem {

    //store attributes for name, notes, price, expiry date
    //  name and notes may contain spaces
    //  name cannot be empty, notes can
    private String name;
    private String notes;
    private double price;
    private LocalDateTime expDate;

    public FoodItem(String name, String notes, double price, LocalDateTime expDate) {

        //name cannot be empty; enforce with exception
        if (name.equals("")) {
            throw new IllegalArgumentException("Name of food cannot be empty.");
        }

        this.name = name;
        this.notes = notes;
        this.price = price;
        this.expDate = expDate;
    }

    //override toString()
    @Override
    public String toString() {
        String foodString = "";
        foodString += "Food: " + name;
        foodString += "\nNotes: " + notes;
        foodString += "\nPrice: " + price;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        foodString += "\nExpiry date: " + expDate.format(formatter);

        //ADD HOW MANY DAYS UNTIL IT EXPIRES

        return foodString;
    }

}
