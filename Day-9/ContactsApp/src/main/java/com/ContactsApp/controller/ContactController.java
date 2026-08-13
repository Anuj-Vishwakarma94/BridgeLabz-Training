package com.ContactsApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ContactsApp.entity.Contact;
import com.ContactsApp.service.ContactService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public Contact addContact(@Valid @RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {

        Contact contact = contactService.getContactById(id);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(
            @PathVariable Long id,
            @Valid @RequestBody Contact contact) {

        Contact updatedContact = contactService.updateContact(id, contact);

        if (updatedContact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {

        contactService.deleteContact(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Contact> searchContacts(@RequestParam(name = "name", defaultValue = "") String name) {
        return contactService.searchContactsByName(name);
    }

    @GetMapping("/favourites")
    public List<Contact> getFavouriteContacts() {
        return contactService.getFavouriteContacts();
    }

    @PatchMapping("/{id}/favourite")
    public ResponseEntity<Contact> toggleFavourite(@PathVariable Long id) {

        Contact updatedContact = contactService.toggleFavourite(id);

        if (updatedContact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedContact);
    }
}