package cmpt213.assignment1.foodexpdatestracker;

import org.w3c.dom.Text;

public class Main {

    //load up json file if there is one
    //creates a menu and call show menu

    public static void main(String[] args) {
        TextMenu menu = new TextMenu();
        menu.displayMenu();
    }

}
