package cmpt213.assignment1.foodexpdatestracker;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Main {

    //ArrayList of food items
    ArrayList<FoodItem> foodList = new ArrayList<>();

    //methods for menu options

    //mainMenu; operations done from here
    public static void mainMenu() {
        TextMenu menu = new TextMenu();
        while (true) {
            int choice = menu.displayMenu();
            switch (choice) {
                case 1:
                    System.out.println("case 1");
                    break;
                case 2:
                    System.out.println("case 2");
                    break;
                case 3:
                    System.out.println("case 3");
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
                    System.out.println("case 7");
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
        mainMenu();
    }

}
