package practice.model;

import practice.util.Util;

import java.util.Scanner;

public class BaseMenu {

    private Scanner menuScanner;
    private Scanner userScanner;
    private int menuInput;
    private String userInput;
    private boolean isMenuClosed;


    public BaseMenu() {
        menuScanner = new Scanner(System.in);
        userScanner = new Scanner(System.in);
        menuInput = 0;
        userInput = "";
        isMenuClosed = false;
    }

    public int getMenuInput() {
        return menuInput;
    }

    public void setMenuInput() {

        String menuEntry = menuScanner.next();

        if (Util.isNumber(menuEntry)) {
            menuInput = Integer.parseInt(menuEntry);
        } else {
            menuInput = 0;
        }
    }

    public void showMenuInput() {
        System.out.println(getMenuInput());
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput() {
        userInput = userScanner.next();
    }

    public void showUserInput() {
        System.out.println(getUserInput());
    }

    public boolean getIsMenuClosed() {
        return isMenuClosed;
    }

    public void setIsMenuClosed(boolean isMenuClosed) {
        this.isMenuClosed = isMenuClosed;
    }

    public Scanner getMenuScanner() {
        return menuScanner;
    }

    public void setMenuScanner(Scanner menuScanner) {
        this.menuScanner = menuScanner;
    }

    public Scanner getUserScanner() {
        return userScanner;
    }

    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

}
