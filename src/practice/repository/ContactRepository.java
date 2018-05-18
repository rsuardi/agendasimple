package practice.repository;

import practice.interfaces.IContact;
import practice.model.Contact;

import java.util.ArrayList;

public class ContactRepository implements IContact{

    public ArrayList<Contact> getList() {
        return list;
    }

    public void setList(ArrayList<Contact> list) {
        this.list = list;
    }

    private ArrayList<Contact> list = new ArrayList<>();

     public ContactRepository(){
         list = new ArrayList<>();
     }

    @Override
    public void showContacts() {

        if(getList().size() == 0){
           System.out.println("No hay contactos en la lista");
        }else{
            for (Contact contact : getList()) {
                System.out.printf("Id: %d. Mi nombre es %s y mi número telefónico es %s%n", contact.getId(), contact.getName(), contact.getPhone());
            }
        }
    }

    @Override
    public void createContact(Contact contact) {

         int id = 0;

         if(list == null) list = new ArrayList<>();
         if(list.size() == 0) id = 1;
         else id = list.size() + 1;

         contact.setId(id);
         list.add(contact);
    }

    @Override
    public void deleteContact(int id) {

         try{
             if(getList().size() == 0){
                 System.out.println("No hay contactos en la lista");
             }else{
                 list.remove(id - 1);
             }
         }catch (Exception ex){
            System.out.println("Este id no existe en la lista");
         }
    }
}
