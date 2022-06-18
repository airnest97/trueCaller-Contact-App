package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactServiceImpl();
    }


    @Test
    void saveContact_findContactReturnsContact(){
        contactService.addContact("Ernest", "Airnest", "0987654321");

        Contact contact = contactService.findById(1);
        assertEquals(contact.getId(), 1);
        assertEquals("Ernest", contact.getFirstName());
        assertEquals("Airnest", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertEquals(1, contactService.size());
    }


    @Test
    void saveContact_AddsMoreThanOneContactTest(){
        contactService.addContact("Ernest", "Airnest", "0987654321");
        contactService.addContact("Ernest", "Wale", "5647382910");
        contactService.addContact("Lanre", "Airnest", "1029384756");

        int count = contactService.size();
        assertEquals(3, count);
    }


    @Test
    void contactCanBeFoundByPhoneNumberTest(){
        contactService.addContact("Ernest", "Airnest", "0987654321");
        contactService.addContact("Airnest", "Wale", "5647382910");
        contactService.addContact("Lanre", "Airnest", "1029384756");
        contactService.addContact("Batman", "jack", "56473838383");

        Contact contact = contactService.findByPhoneNumber("56473838383");
        assertEquals("56473838383", contact.getPhoneNumber());
        assertEquals("Batman", contact.getFirstName());
        assertEquals("jack", contact.getLastName());
        assertEquals(4, contact.getId());
    }


    @Test
    void contactReturnsAllSavedContactTest(){
        contactService.addContact("Ernest", "Airnest", "0987654321");
        contactService.addContact("Ernest", "Wale", "5647382910");
        contactService.addContact("Lanre", "Airnest", "1029384756");

        List <Contact> contacts = contactService.findAll();
        assertEquals(3, contacts.size());
    }


    @Test
    void saveContact_findContactById_And_DeleteContact(){
        contactService.addContact("Ernest", "Airnest", "0987654321");
        contactService.addContact("Ernest", "Wale", "5647382910");
        contactService.addContact("Lanre", "Airnest", "1029384756");

        contactService.deleteById(1);
        int count = contactService.size();
        assertEquals(2, count);
    }


    @Test
    void savedContactCanBeUpdatedById(){
        contactService.addContact("Ernest", "Airnest", "0987654321");
        contactService.addContact("James", "Wale", "5647382910");
        contactService.addContact("Lanre", "Airnest", "1029384756");

        contactService.updateById(1, "Spider-man", "Batman", "1234567890");

        Contact contact = contactService.findById(1);

        assertEquals("Spider-man", contact.getFirstName());
        assertEquals("Batman", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals(1, contact.getId());
    }


    @Test
    void contactReturnsAllMatchingNamesTest(){
        contactService.addContact("Ernest", "Airnest", "0987654321");
        contactService.addContact("Airnest", "Wale", "5647382910");
        contactService.addContact("Lanre", "Airnest", "1029384756");
        contactService.addContact("Batman", "jack", "56473838383");

        List <Contact> contacts = contactService.findByName("Airnest");
        assertEquals(3, contacts.size());
    }


//    @Test
//    void saveContact_findContactByFirstName_And_DeleteContact(){
//        contactService.addContact("Ernest", "Airnest", "0987654321");
//        contactService.addContact("James", "Wale", "5647382910");
//        contactService.addContact("Lanre", "Airnest", "1029384756");

//        contactService.deleteByFirstName("Ernest");
//        int count = contactService.size();
//        assertEquals(2, count);
//    }


//    @Test
//    void saveContact_findContactByLastName_And_DeleteContact(){
//        contactService.addContact("Ernest", "Airnest", "0987654321");
//        contactService.addContact("James", "Wale", "5647382910");
//        contactService.addContact("Lanre", "Airnest", "1029384756");

//        contactService.deleteByLastName("Wale");
//        int count = contactService.size();
//        assertEquals(2, count);
//    }


//    @Test
//    void saveContact_findContactByPhoneNumber_And_DeleteContact(){
//        contactService.addContact("Ernest", "Airnest", "0987654321");
//        contactService.addContact("James", "Wale", "5647382910");
//        contactService.addContact("Lanre", "Airnest", "1029384756");

//        contactService.deleteByPhoneNumber("0987654321");
//        int count = contactService.size();
//        assertEquals(2, count);
//    }


//    @Test
//    void contactReturnsAllMatchingFirstNameTest(){
//        contactService.addContact("Ernest", "Airnest", "0987654321");
//        contactService.addContact("Ernest", "Wale", "5647382910");
//        contactService.addContact("Lanre", "Airnest", "1029384756");

//        List <Contact> contacts = contactService.findByName("Ernest");
//        assertEquals(2, contacts.size());
//    }
}