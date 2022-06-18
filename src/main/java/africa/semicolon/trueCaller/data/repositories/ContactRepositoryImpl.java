package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    List<Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
        boolean checkId = false;
        for (Contact letsFind : contacts) {
            if (letsFind.getId() == contact.getId()) {
                checkId = true;
                break;
            }
        }
        if (!checkId) {
            contact.setId(contacts.size() + 1);
        }
        contacts.add(contact);
        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }

    @Override
    public Contact findByLastName(String lastName) {
        for (Contact contact : contacts) {
            if (lastName.equalsIgnoreCase(contact.getLastName())) {
                return contact;
            }
        }
        throw new NullPointerException("Contact not found");
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (phoneNumber.equals(contact.getPhoneNumber())) {
                return contact;
            }
        }
        throw new NullPointerException("Number not found");
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public void deleteById(int id) {
        Contact contact = findById(id);
        contacts.remove(contact);
    }


    @Override
    public List<Contact> findByName(String name) {
        List<Contact> contacts = findAll();
        List<Contact> newContact = new ArrayList<>();
        for (Contact contact : contacts) {
            if (name.equalsIgnoreCase(contact.getFirstName()) || name.equalsIgnoreCase(contact.getLastName())) {
                newContact.add(contact);
            }
        }
        return newContact;
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (Contact contact : contacts) {
            if (firstName.equalsIgnoreCase(contact.getFirstName())) {
                return contact;
            }
        }
        throw new NullPointerException("Contact not found");
    }

    @Override
    public Contact updateById(int id, String firstName, String lastName, String phoneNumber) {
        Contact contact = findById(id);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        return save(contact);
    }

//    @Override
//    public void deleteByFirstName(String firstName) {
//        Contact contact = findByFirstName(firstName);
//        contacts.remove(contact);
//    }

//    @Override
//    public void deleteByLastName(String lastName) {
//        Contact contact = findByLastName(lastName);
//        contacts.remove(contact);
//    }

//    @Override
//    public void deleteByPhoneNumber(String phoneNumber) {
//        Contact contact = findByPhoneNumber(phoneNumber);
//        contacts.remove(contact);
//    }
}
