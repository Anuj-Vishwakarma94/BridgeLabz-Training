package com.ContactsApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ContactsApp.entity.Contact;
import com.ContactsApp.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {

        Contact existingContact = contactRepository.findById(id).orElse(null);

        if (existingContact == null) {
            return null;
        }

        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhone(contact.getPhone());
        existingContact.setAlternatePhone(contact.getAlternatePhone());
        existingContact.setFavourite(contact.isFavourite());

        return contactRepository.save(existingContact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> searchContactsByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return getAllContacts();
        }
        return contactRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

    @Override
    public List<Contact> getFavouriteContacts() {
        return contactRepository.findByIsFavouriteTrue();
    }

    @Override
    public Contact toggleFavourite(Long id) {
        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact == null) {
            return null;
        }
        existingContact.setFavourite(!existingContact.isFavourite());
        return contactRepository.save(existingContact);
    }
}