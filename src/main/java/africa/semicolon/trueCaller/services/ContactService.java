package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(String id);

    List<Contact> findByName(String name);


    List<Contact> findAll();

    void deleteById(String id);


    Contact updateById(String id, String firstName, String lastName, String phoneNumber);

    Contact findByPhoneNumber(String phoneNumber);
}
