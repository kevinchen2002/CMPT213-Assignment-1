package cmpt213.assignment1.foodexpdatestracker;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static java.time.LocalTime.now;

public class Main {

    //ArrayList of food items
    static ArrayList<FoodItem> foodList = new ArrayList<>();

    //helper functions to ensure numerical input
    private static int getInt() {
        int choice;
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                choice = Integer.parseInt(in.nextLine());
                return choice;
            } catch (NumberFormatException nfe) {
                System.out.println("Not an integer");
            }
        }
    }
    private static double getDouble() {
        double choice;
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                choice = Double.parseDouble(in.nextLine());
                return choice;
            } catch (NumberFormatException nfe) {
                System.out.println("Not a double!");
            }
        }
    }

    //methods for menu options

    //case 1: list all food items
    public static void listFood() {
        if (foodList.isEmpty()) {
            System.out.println("There are no food items!");
        }
        int itemNum = 1;
        for (FoodItem item : foodList) {
            System.out.println("\nFood Item #" + itemNum);
            System.out.println(item);
            itemNum++;
        }
    }

    //case 2: add a food item
    public static void addFood() {
        Scanner in = new Scanner(System.in);

        String foodName = "";
        while (foodName.equals("")) {
            System.out.println("Enter the name of the new food item: ");
            foodName = in.nextLine();
        }

        String foodNotes = "";
        System.out.println("Enter any notes for the new food item: ");
        foodNotes = in.nextLine();

        //get price
        double price = -1.0;
        while (price < 0) {
            System.out.println("Enter the price of this item: ");
            price = getDouble();
        }

        //get expiry year
        int year = -1;
        while (year < 2000) {
            System.out.println("Enter the year of the expiry date: ");
            year = getInt();
        }

        //get expiry month
        int month = -1;
        while (month < 1 || month > 12) {
            System.out.println("Enter the month of the expiry date: ");
            month = getInt();
        }

        //get expiry day
        int day = -1;
        //max day varies by month
        int maxDay = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        }
        else if (month == 2) {
            maxDay = 28;
        }
        while (day < 1 || day > maxDay) {
            System.out.println("Enter the day of the expiry date: ");
            day = getInt();
        }

        LocalDateTime expiry = LocalDateTime.of(year, month, day, 11, 59);
        FoodItem newFoodItem = new FoodItem(foodName, foodNotes, price, expiry);

        //insert in the correct spot to ensure ascending order of dates
        int maxSize = foodList.size();
        for (int i = 0; i < maxSize; i++) {
            if (expiry.isBefore(foodList.get(i).getExpDate())) {
                foodList.add(i, newFoodItem);
                break;
            }
            else if (i == maxSize-1) {
                foodList.add(newFoodItem);
                break;
            }
        }

        System.out.println("Item " + foodName + " has been added!");
    }

    public static void removeFood() {
        listFood();
        //get the item that the user will delete
        int toDelete = -1;
        while (toDelete < 1 || toDelete > foodList.size()) {
            System.out.println("Which item would you like to delete? ");
            toDelete = getInt();
        }
        FoodItem removed = foodList.get(toDelete-1);
        foodList.remove(toDelete-1);
        System.out.println(removed.getName() + " has been removed!");
    }

    //mainMenu; operations done from here
    public static void mainMenu() {
        TextMenu menu = new TextMenu();
        menu.printTitle();
        int choice = 0;
        while (choice != 7) {
            choice = menu.displayMenu();
            switch (choice) {
                case 1:
                    listFood();
                    break;
                case 2:
                    addFood();
                    break;
                case 3:
                    removeFood();
                    break;
                case 4:
                    System.out.println("case 4");
                    break;
                case 5:
                    System.out.println("case 5");
                    break;
                case 6:
                    System.out.println("case 6");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Pick one of the above options");
                    break;
            }
        }

    }

    //load up json file if there is one
    //creates a menu and call show menu

    //main
    public static void main(String[] args) {

        //temp stuff for testing
        FoodItem test = new FoodItem("Apple", "Tim Apple", 1.00, LocalDateTime.now());
        foodList.add(test);

        FoodItem test2 = new FoodItem("Pear", "Dis a pear", 19.94, LocalDateTime.now());
        foodList.add(test2);

        FoodItem test3 = new FoodItem("Orange", "", 2.35, LocalDateTime.now());
        foodList.add(test3);

        mainMenu();
    }

}
