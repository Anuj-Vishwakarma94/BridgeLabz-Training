package com.ContactsApp.service;

import java.util.List;

import com.ContactsApp.entity.Contact;

public interface ContactService {

    Contact addContact(Contact contact);

    List<Contact> getAllContacts();

    Contact getContactById(Long id);

    Contact updateContact(Long id, Contact contact);

    void deleteContact(Long id);

    List<Contact> searchContactsByName(String name);

    List<Contact> getFavouriteContacts();

    Contact toggleFavourite(Long id);
}