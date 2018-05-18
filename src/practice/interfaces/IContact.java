package practice.interfaces;

import practice.model.Contact;

import java.util.ArrayList;

public interface IContact {

    void createContact(Contact contact);
    void deleteContact(int id);

    void printContacts();

    Contact getContact();

    void setContact(Contact contact);

    boolean getIsValidContact();

    void setIsValidContact(boolean validContact);

    ArrayList<Contact> getList();

    void setList(ArrayList<Contact> list);
}
