package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository = new ContactRepositoryImpl();


    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactRepository.save(contact);

    }

    @Override
    public Contact findById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> findByName(String name) {
        List<Contact> contacts = contactRepository.findAll();
        List<Contact> newContact = new ArrayList<>();
        for (Contact contact : contacts) {
            if (name.equalsIgnoreCase(contact.getFirstName()) || name.equalsIgnoreCase(contact.getLastName())) {
                newContact.add(contact);
            }
        }
        return newContact;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public int size() {
        return contactRepository.count();
    }

    @Override
    public void updateById(int id, String firstName, String lastName, String phoneNumber) {
        contactRepository.updateById(id, firstName, lastName, phoneNumber);
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        return contactRepository.findByPhoneNumber(phoneNumber);
    }

//    @Override
//    public void deleteByFirstName(String firstName) {
//        contactRepository.deleteByFirstName(firstName);
//    }
//
//    @Override
//    public void deleteByLastName(String lastName) {
//        contactRepository.deleteByLastName(lastName);
//    }
//
//    @Override
//    public void deleteByPhoneNumber(String phoneNumber) {
//        contactRepository.deleteByPhoneNumber(phoneNumber);
//    }
//
//    @Override
//    public List<Contact> findByFirstName(String firstName) {
//        List<Contact> contacts = contactRepository.findAll();
//        List<Contact> newContact = new ArrayList<>();
//        for (Contact contact : contacts) {
//            if (firstName.equalsIgnoreCase(contact.getFirstName())) {
//                newContact.add(contact);
//            }
//        }
//        return newContact;
//    }
//
//    @Override
//    public List<Contact> findByLastName(String lastName) {
//        List<Contact> contacts = contactRepository.findAll();
//        List<Contact> newContact = new ArrayList<>();
//        for (Contact contact : contacts) {
//            if (lastName.equalsIgnoreCase(contact.getLastName())) {
//                newContact.add(contact);
//            }
//        }
//        return newContact;
//    }
}
