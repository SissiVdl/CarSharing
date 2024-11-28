package carsharing;

import carsharing.menus.MainMenu;

public class Main {

    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        while (true) {
            menu.show();
        }
    }
}