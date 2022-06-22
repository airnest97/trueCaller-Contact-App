package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int id);

    List<Contact> findByName(String name);


    List<Contact> findAll();

    void deleteById(int id);

    int size();

    void updateById(int id, String firstName, String lastName, String phoneNumber);

    Contact findByPhoneNumber(String phoneNumber);

//    void deleteByFirstName(String firstName);

//    void deleteByLastName(String lastName);

//    void deleteByPhoneNumber(String phoneNumber);

//    List<Contact> findByLastName(String lastName);

//    List<Contact> findByFirstName(String firstName);
}
