package practice.ui;

import practice.model.Contact;
import practice.repository.ContactRepository;
import practice.util.Util;

import java.util.Scanner;


public class Menu {

    private Scanner menuScanner = new Scanner(System.in);
    private Scanner userScanner = new Scanner(System.in);
    private int menuInput = 0;
    private String userInput = "";
    private boolean isMenuClosed = false;
    private ContactRepository contactRepository;
    private Contact contact;
    private boolean isValidContact = false;

    public Menu() {
        contactRepository = new ContactRepository();
        contact = new Contact();
    }

    public  void showMenu(){

        System.out.println("Bienvenido a tu agenda simple");
        System.out.println("--Seleccione una opción del menú");
        System.out.println("-- 1 Listar contactos");
        System.out.println("-- 2 Introducir contacto");
        System.out.println("-- 3 Eliminar contacto");
        System.out.println("-- 4 Salir");
        System.out.println("\033[3mDigite una opcion para continuar...\033[3m");
    }

    private int getMenuInput() {
        return menuInput;
    }

    public void setMenuInput() {

        String menuEntry = menuScanner.next();

        if(Util.isNumber(menuEntry)){
            menuInput = Integer.parseInt(menuEntry);
        }
        else {
            menuInput = 0;
        }
    }

    public void showMenuInput(){

        System.out.println(getMenuInput());
    }

    private String getUserInput() {

        return userInput;
    }

    private void setUserInput() {

        String userEntry = userScanner.next();
        userInput = userEntry;
    }

    public void showUserInput(){
        System.out.println(getUserInput());
    }

    public boolean getIsMenuClosed(){
        return isMenuClosed;
    }

    private void setIsMenuClosed(boolean value) {
        isMenuClosed = value;
    }

    private void exitMenu() {
        setIsMenuClosed(true);
        System.out.println("Vuelva pronto!");
        System.exit(0);
    }

    public void doSomething(){

        int input = getMenuInput();

        switch (input){
            case 1:
                contactRepository.showContacts();
                break;
            case 2:
                sendContact();
                if(isValidContact){
                    contactRepository.createContact(contact);
                    System.out.println("Contacto creado con éxito!");
                }else{
                    System.out.println("No se pudo crear el contacto");
                }
                break;
            case 3:
                if(contactRepository.getList().size() == 0){
                    System.out.println("No hay contactos en la lista");
                }else{
                    contactRepository.deleteContact(getContactId());
                }
                break;
            case 4:
                exitMenu();
                break;
            default:
                System.out.println("Debe elegir una opcion de las 4 que aparecen en el menú.");
                break;
        }
        reInit();
    }

    private void printContacts() {
        contactRepository.showContacts();
    }

    private void reInit(){
        contact = new Contact();
        isValidContact = false;
        menuScanner = new Scanner(System.in);
        userScanner = new Scanner(System.in);
        /*
        isOpen = true;
        resultado = 0;
        list.clear();
        */
    }

    private void sendContact(){

        /*
        System.out.println("Digite el id");
        contact.setId(getContactId());
        */

        System.out.println("Digite el nombre");
        contact.setName(getContactName());

        System.out.println("Digite el teléfono");
        contact.setPhone(getContactPhone());
    }

    private String getContactPhone() {
        String phone = userScanner.next();
        isValidContact = true;
        return phone;
    }

    private String getContactName() {
        String name = userScanner.next();
        isValidContact = true;
        return name;
    }

    public int getContactId(){

        System.out.println("Introduzca el id");
        int id = 0;
        try{
            id = userScanner.nextInt();
            isValidContact = true;
        }catch(Exception ex){
            isValidContact = false;
            System.out.println("El id debe ser un número");
            return 0;
        }
        return id;
    }
}
