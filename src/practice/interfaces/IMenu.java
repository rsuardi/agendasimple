package practice.interfaces;

public interface IMenu {

    void showMenu();

    private void exitMenu() {
    }

    void doSomething();

    private void reInit() {
    }

    int getMenuInput();

    void setMenuInput();

    void showMenuInput();

    String getUserInput();

    void setUserInput();

    void showUserInput();

    boolean getIsMenuClosed();

    void setIsMenuClosed(boolean value);

    void printOutput();

    String getReturnMessage();

}
