package cmpt213.assignment1.foodexpdatestracker;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static java.time.LocalTime.now;

public class Main {

    /**
     * ArrayList of FoodItems
     */
    static ArrayList<FoodItem> foodList = new ArrayList<>();

    /**
     * helper function that ensures numerical input
     * @return a valid integer
     */
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

    /**
     * helper function that ensures numerical input
     * @return a valid double
     */
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

    /**
     * menu option 1; lists all food items
     */
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

    /**
     * menu option 2; takes in fields and adds a food item
     * looks at the list to ensure that it is inserted in order by expiration date
     */
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
        final int MIN_YEAR = 2000;
        while (year < MIN_YEAR) {
            System.out.println("Enter the year of the expiry date: ");
            year = getInt();
        }

        //get expiry month
        int month = -1;
        final int MAX_MONTH = 12;
        while (month < 1 || month > MAX_MONTH) {
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

    /**
     * menu option 3; removes a food
     */
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

    /**
     * menu option 4; lists expired foods
     */
    public static void listExpired() {
        if (foodList.isEmpty()) {
            System.out.println("There are no food items!");
        }
        int itemNum = 1;
        boolean noExpired = true;
        for (FoodItem item : foodList) {
            if (item.isExpired()) {
                System.out.println("\nFood Item #" + itemNum);
                System.out.println(item);
                noExpired = false;
                itemNum++;
            }
        }
        if (noExpired && foodList.size() != 0) {
            System.out.println("There are no expired items!");
        }
    }

    /**
     * menu option 5; lists non-expired foods
     */
    public static void listNotExpired() {
        if (foodList.isEmpty()) {
            System.out.println("There are no food items!");
        }
        int itemNum = 1;
        boolean allExpired = true;
        for (FoodItem item : foodList) {
            if (!item.isExpired()) {
                System.out.println("\nFood Item #" + itemNum);
                System.out.println(item);
                allExpired = false;
                itemNum++;
            }
        }
        if (allExpired && foodList.size() != 0) {
            System.out.println("All food items are expired!");
        }
    }

    /**
     * menu option 6; lists foods expiring within seven days
     */
    public static void expiringSevenDays() {
        if (foodList.isEmpty()) {
            System.out.println("There are no food items!");
        }
        int itemNum = 1;
        boolean noneWithinSevenDays = true;
        for (FoodItem item : foodList) {
            if (item.getDaysUntilExp() <= 7 && !item.isExpired()) {
                System.out.println("\nFood Item #" + itemNum);
                System.out.println(item);
                noneWithinSevenDays = false;
                itemNum++;
            }
        }
        if (noneWithinSevenDays && foodList.size() != 0) {
            System.out.println("There are no foods expiring within 7 days!");
        }
    }

    /**
     * calls the menu from TextMenu object and performs the corresponding operation
     */
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
                    listExpired();
                    break;
                case 5:
                    listNotExpired();
                    break;
                case 6:
                    expiringSevenDays();
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

    public static void main(String[] args) {

        //temp stuff for testing
        FoodItem test = new FoodItem("Apple", "Tim Apple", 1.00, LocalDateTime.now());
        foodList.add(test);

        LocalDateTime date2 = LocalDateTime.now();
        date2 = date2.plusDays(3);
        FoodItem test2 = new FoodItem("Pear", "Dis a pear", 19.94, date2);
        foodList.add(test2);

        LocalDateTime date3 = LocalDateTime.now();
        date3 = date3.plusDays(10);
        FoodItem test3 = new FoodItem("Orange", "", 2.35, date3);
        foodList.add(test3);

        mainMenu();
    }
}
