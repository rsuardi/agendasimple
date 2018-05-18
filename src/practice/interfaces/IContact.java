package practice.interfaces;

import practice.model.Contact;

public interface IContact {

    void showContacts();
    void createContact(Contact contact);
    void deleteContact(int id);
}
