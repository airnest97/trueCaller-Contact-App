package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;


public interface ContactRepository {
    int count();

    Contact save(Contact contact);

    Contact findByFirstName(String firstName);

    Contact findById(int id);

    Contact findByLastName(String lastName);

    Contact findByPhoneNumber(String phoneNumber);

    List<Contact> findAll();

    void deleteById(int id);

    List<Contact> findByName(String name);

//    void deleteByFirstName(String firstName);
//
//    void deleteByLastName(String lastName);
//
//    void deleteByPhoneNumber(String phoneNumber);
}
