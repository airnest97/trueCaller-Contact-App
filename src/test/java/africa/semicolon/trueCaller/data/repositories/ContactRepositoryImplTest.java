package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private ContactRepository contactRepository;
    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepositoryImpl();
    }
    @Test
    void saveContact_countIsOneTest(){
        Contact contact = new Contact();
        contact.setFirstName("Samson");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        assertEquals(1, contactRepository.count());
    }

    @Test
    void saveContactTwice_countIsTwoTest(){
        Contact contact = new Contact();
        contact.setFirstName("Samson");

        Contact contact1 = new Contact();
        contact1.setFirstName("Ernest");

        Contact savedContact = contactRepository.save(contact);
        Contact savedContact2 = contactRepository.save(contact1);

        assertEquals(1, savedContact.getId());
        assertEquals(2, savedContact2.getId());
        assertEquals(2, contactRepository.count());
    }

    @Test
    void saveContact_findByIdReturnsContactTest(){
        Contact contact = new Contact();
        contact.setFirstName("Samson");

        Contact contact1 = new Contact();
        contact1.setFirstName("Ernest");

        contactRepository.save(contact);
        contactRepository.save(contact1);

        Contact foundContact = contactRepository.findById(1);
        Contact secondContact = contactRepository.findById(2);

        assertEquals(1, foundContact.getId());
        assertEquals(2, secondContact.getId());
        assertEquals("Samson", foundContact.getFirstName());
        assertEquals("Ernest", secondContact.getFirstName());
    }

    @Test
    void saveContact_findByNameReturnsContactTest(){
        Contact contact = new Contact();
        contact.setFirstName("Samson");

        Contact contact1 = new Contact();
        contact1.setFirstName("Ernest");

        contactRepository.save(contact);
        contactRepository.save(contact1);

        Contact foundContact = contactRepository.findByFirstName("Samson");
        Contact secondContact = contactRepository.findByFirstName("Ernest");

        assertEquals(1, foundContact.getId());
        assertEquals(2, secondContact.getId());
        assertEquals("Samson", foundContact.getFirstName());
        assertEquals("Ernest", secondContact.getFirstName());
    }

    @Test
    void saveContact_findByLastNameReturnsContactTest(){
        Contact contact = new Contact();
        contact.setLastName("Samuel");

        Contact contact1 = new Contact();
        contact1.setLastName("Ernest");

        contactRepository.save(contact);
        contactRepository.save(contact1);

        Contact foundContact = contactRepository.findByLastName("Samuel");
        Contact secondContact = contactRepository.findByLastName("Ernest");

        assertEquals(1, foundContact.getId());
        assertEquals(2, secondContact.getId());
        assertEquals("Samuel", foundContact.getLastName());
        assertEquals("Ernest", secondContact.getLastName());
    }

    @Test
    void saveContact_findByPhoneNumberReturnsContactTest(){
        Contact contact = new Contact();
        contact.setPhoneNumber("0987654321");

        Contact contact1 = new Contact();
        contact1.setPhoneNumber("1234567890");

        contactRepository.save(contact);
        contactRepository.save(contact1);

        Contact foundContact = contactRepository.findByPhoneNumber("0987654321");
        Contact secondContact = contactRepository.findByPhoneNumber("1234567890");

        assertEquals(1, foundContact.getId());
        assertEquals(2, secondContact.getId());
        assertEquals("0987654321", foundContact.getPhoneNumber());
        assertEquals("1234567890", secondContact.getPhoneNumber());
    }

    @Test
    void contactReturnsAllMatchingNamesTest(){
        Contact contact = new Contact(1, "Ernest", "Jungle", "12345");
        Contact contact2 = new Contact(2, "west", "east", "54321");
        Contact contact3 = new Contact(3, "north", "south", "2345");
        Contact contact4 = new Contact(4, "Ernest", "south", "12345");
        Contact contact5 = new Contact(5, "Ernest", "lion", "12345");

        contactRepository.save(contact);
        contactRepository.save(contact2);
        contactRepository.save(contact3);
        contactRepository.save(contact4);
        contactRepository.save(contact5);

        List<Contact> contacts = contactRepository.findByName("Ernest");
        assertEquals(3, contacts.size());
        List<Contact> contacts2 = contactRepository.findByName("south");
        assertEquals(2, contacts2.size());
    }
}