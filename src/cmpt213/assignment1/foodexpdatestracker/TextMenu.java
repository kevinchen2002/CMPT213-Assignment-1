package cmpt213.assignment1.foodexpdatestracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextMenu {

    //attributes for menu title and menu options
    //  option seven saves to json file
    private final String title = "\n  ______              _   ______            _              _____        _              _______             _             \n" +
            " |  ____|            | | |  ____|          (_)            |  __ \\      | |            |__   __|           | |            \n" +
            " | |__ ___   ___   __| | | |__  __  ___ __  _ _ __ _   _  | |  | | __ _| |_ ___  ___     | |_ __ __ _  ___| | _____ _ __ \n" +
            " |  __/ _ \\ / _ \\ / _` | |  __| \\ \\/ / '_ \\| | '__| | | | | |  | |/ _` | __/ _ \\/ __|    | | '__/ _` |/ __| |/ / _ \\ '__|\n" +
            " | | | (_) | (_) | (_| | | |____ >  <| |_) | | |  | |_| | | |__| | (_| | ||  __/\\__ \\    | | | | (_| | (__|   <  __/ |   \n" +
            " |_|  \\___/ \\___/ \\__,_| |______/_/\\_\\ .__/|_|_|   \\__, | |_____/ \\__,_|\\__\\___||___/    |_|_|  \\__,_|\\___|_|\\_\\___|_|   \n" +
            "                                     | |            __/ |                                                                \n" +
            "                                     |_|           |___/                                                                 \n";

    private final String[] menuOptions = new String[] {"List food items", "Add new food item", "Remove food item",
            "List expired food items", "List non-expired food items", "List food items expiring witin 7 days", "Exit"};

    private final int NUM_MENU_OPTIONS = 7;

    //constructor
    public TextMenu() {}

    //DELETE LATER
    public void printTitle() {
        System.out.println(title);
    }

    //show menu method with a switch case and input handling
    public int displayMenu() {
        printTitle();
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Today is: " + currentTime.format(formatter));

        for (int i = 1; i <= NUM_MENU_OPTIONS; i++) {
            System.out.println(i + ": " + menuOptions[i-1]);
        }

        int choice = -1;
        Scanner in = new Scanner(System.in);
        while (choice < 1 || choice > 7) {
            System.out.println("Choose an option by entering 1 - 7: ");
            try {
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Not an integer");
            }
        }

        return choice;
    }

}
