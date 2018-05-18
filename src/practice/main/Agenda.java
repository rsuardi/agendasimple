package practice.main;

import practice.interfaces.IMenu;
import practice.ui.Menu;

public class Agenda {

    public static void main(String[] args) {

        IMenu menu = new Menu();

        while (!menu.getIsMenuClosed()){
            menu.showMenu();
            menu.setMenuInput();
            menu.doSomething();
        }
    }
}
