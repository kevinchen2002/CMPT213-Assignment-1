package cmpt213.assignment1.foodexpdatestracker;

import java.util.ArrayList;
import java.util.Arrays;

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
    private final ArrayList<String> menuOptions = new ArrayList<> (Arrays.asList("List food items", "Add new food item", "Remove food item",
            "List expired food items", "List non-expired food items", "List food items expiring witin 7 days", "Exit"));

    private ArrayList<FoodItem> foodList;

    public TextMenu() {
        this.foodList = new ArrayList<>();
    }

    //methods for each of seven options

    //DELETE LATER
    public void printTitle() {
        System.out.println(title);
    }

    //show menu method with a switch case and input handling

}
