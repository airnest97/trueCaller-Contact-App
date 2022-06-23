package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.exceptions.NoContactException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public Contact addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public Contact findById(String id) {
        Optional<Contact> found = contactRepository.findById(id);
        if (found.isEmpty()) throw new NoContactException("Contact not found");
        return found.get();
    }

    @Override
    public List<Contact> findByName(String name) {
        List<Contact> contacts = new ArrayList<>();
        contacts.addAll(contactRepository.findByFirstName(name));
        contacts.addAll(contactRepository.findByLastName(name));
        return contacts;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact updateById(String id, String firstName, String lastName, String phoneNumber) {
        Contact contact = findById(id);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        return contactRepository.save(contact);
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        return contactRepository.findByPhoneNumber(phoneNumber);
    }

}
