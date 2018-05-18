package practice.repository;

import practice.interfaces.IContact;
import practice.model.Contact;

import java.util.ArrayList;

public class ContactRepository implements IContact {

    private ArrayList<Contact> list;
    private Contact contact;
    private boolean isValidContact;

    public ContactRepository() {
        list = new ArrayList<>();
        contact = new Contact();
        isValidContact = false;
    }

    public ArrayList<Contact> getList() {
        return list;
    }

    public void setList(ArrayList<Contact> list) {
        this.list = list;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean getIsValidContact() {
        return isValidContact;
    }

    public void setIsValidContact(boolean validContact) {
        isValidContact = validContact;
    }

    @Override
    public void printContacts() {

        try {
            if (getList().size() == 0) {
                System.out.println("No hay contactos en la lista");
            } else {
                for (Contact contact : getList()) {
                    System.out.printf("Id: %d. Mi nombre es %s y mi número telefónico es %s%n", contact.getId(), contact.getName(), contact.getPhone());
                }
            }
        } catch (Exception ex) {
        }
    }

    @Override
    public void createContact(Contact contact) {

        int id;

         if(list == null) list = new ArrayList<>();
         if(list.size() == 0) id = 1;
         else id = list.size() + 1;

         contact.setId(id);
         list.add(contact);
    }

    @Override
    public void deleteContact(int id) {

        try {
            if (getList().size() == 0) {
                System.out.println("No hay contactos en la lista");
            } else {
                String name = list.get(id - 1).getName();
                list.remove(id - 1);
                System.out.printf("El contacto %s ha sido borrado!%n", name);
            }
        } catch (Exception ex) {
            System.out.println("Este id no existe en la lista");
        }
    }
}
