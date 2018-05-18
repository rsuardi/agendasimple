package practice.ui;

import practice.interfaces.IMenu;
import practice.model.BaseMenu;
import practice.model.Contact;
import practice.repository.ContactRepository;

import java.io.IOException;
import java.util.Scanner;

public class Menu extends BaseMenu implements IMenu {

    private ContactRepository contactRepository;

    public Menu() {
        super();
        if (contactRepository == null)
            contactRepository = new ContactRepository();
    }

    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void showMenu() {

        System.out.println("Bienvenido a tu agenda simple");
        System.out.println("--Seleccione una opción del menú");
        System.out.println("-- 1 Listar contactos");
        System.out.println("-- 2 Introducir contacto");
        System.out.println("-- 3 Eliminar contacto");
        System.out.println("-- 4 Salir");
        System.out.println("\033[3mDigite una opcion para continuar...\033[3m");
    }

    public void doSomething(){

        int input = getMenuInput();

        switch (input){
            case 1:
                printOutput();
                break;
            case 2:
                sendContact();
                break;
            case 3:
                deleteContact();
                break;
            case 4:
                exitMenu();
                break;
            default:
                defaultAction();
                break;
        }
        reInit();
    }

    public void printOutput() {

        try {
            getContactRepository().printContacts();
            System.out.println(getReturnMessage());
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitMenu() {

        setIsMenuClosed(true);
        System.out.println("Vuelva pronto!");
        System.exit(0);
    }

    private void reInit(){

        getContactRepository().setContact(new Contact());
        getContactRepository().setIsValidContact(false);
        setMenuScanner(new Scanner(System.in));
        setUserScanner(new Scanner(System.in));
    }

    private void sendContact(){

        try {
            System.out.println("Digite el nombre");
            getContactRepository().getContact().setName(getContactName());

            System.out.println("Digite el teléfono");
            getContactRepository().getContact().setPhone(getContactPhone());

            if (getContactRepository().getIsValidContact()) {
                getContactRepository().createContact(getContactRepository().getContact());
                System.out.println("Contacto creado con éxito!");
                System.out.println(getReturnMessage());
                System.in.read();
            } else {
                System.out.println("No se pudo crear el contacto");
                System.out.println(getReturnMessage());
                System.in.read();
            }
        } catch (IOException ex) {

        }

    }

    private String getContactPhone() {

        String phone = getUserScanner().next();
        getContactRepository().setIsValidContact(true);
        return phone;
    }

    private String getContactName() {

        String name = getUserScanner().next();
        getContactRepository().setIsValidContact(true);
        return name;
    }

    private int getContactId() {

        System.out.println("Introduzca el id");
        int id;
        try{
            id = getUserScanner().nextInt();
            getContactRepository().setIsValidContact(true);
            return id;
        }catch(Exception ex){
            getContactRepository().setIsValidContact(false);
            System.out.println("El id debe ser un número");
            return 0;
        }
    }

    private void deleteContact() {
        try {
            if (getContactRepository().getList().size() == 0) {
                System.out.println("No hay contactos en la lista");
                System.out.println(getReturnMessage());
                System.in.read();
            } else {
                printOutput();
                getContactRepository().deleteContact(getContactId());
                System.out.println(getReturnMessage());
                System.in.read();
            }
        } catch (IOException ex) {
        }
    }

    private void defaultAction() {
        try {
            System.out.println("Debe elegir una opcion de las 4 que aparecen en el menú.");
            System.out.println(getReturnMessage());
            System.in.read();
        } catch (IOException ex) {
        }
    }

    private void cls() {
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception ex) {
        }
    }
}
