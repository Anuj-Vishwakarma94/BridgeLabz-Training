package com.ContactsApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ContactsApp.entity.Contact;
import com.ContactsApp.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @Test
    void shouldAddContact() {
        Contact contact = new Contact(1L, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", false);

        when(contactRepository.save(any(Contact.class))).thenReturn(contact);

        Contact response = contactService.addContact(contact);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Anuj", response.getFirstName());
        assertEquals("Vishwakarma", response.getLastName());
        assertEquals("anuj@example.com", response.getEmail());
        assertEquals("9876543210", response.getPhone());
        assertEquals("9123456789", response.getAlternatePhone());

        verify(contactRepository).save(any(Contact.class));
    }

    @Test
    void shouldGetAllContacts() {
        Contact contact1 = new Contact(1L, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", false);
        Contact contact2 = new Contact(2L, "Rahul", "Sharma", "rahul@example.com", "9999999999", "8888888888", false);

        when(contactRepository.findAll()).thenReturn(Arrays.asList(contact1, contact2));

        List<Contact> contacts = contactService.getAllContacts();

        assertEquals(2, contacts.size());
        assertEquals("Anuj", contacts.get(0).getFirstName());
        assertEquals("Rahul", contacts.get(1).getFirstName());

        verify(contactRepository).findAll();
    }

    @Test
    void shouldGetContactById() {
        Contact contact = new Contact(1L, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", false);

        when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));

        Contact response = contactService.getContactById(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Anuj", response.getFirstName());
        assertEquals("Vishwakarma", response.getLastName());

        verify(contactRepository).findById(1L);
    }

    @Test
    void shouldReturnNullWhenContactNotFound() {
        when(contactRepository.findById(99L)).thenReturn(Optional.empty());

        Contact response = contactService.getContactById(99L);

        assertNull(response);

        verify(contactRepository).findById(99L);
    }

    @Test
    void shouldUpdateContact() {
        Contact existingContact = new Contact(1L, "Anuj", "Vishwakarma", "old@example.com", "1111111111", "2222222222", false);
        Contact updateRequest = new Contact(null, "Anuj", "Vishwakarma", "anuj.new@example.com", "9876543210", "9123456789", true);

        when(contactRepository.findById(1L)).thenReturn(Optional.of(existingContact));
        when(contactRepository.save(any(Contact.class))).thenReturn(existingContact);

        Contact response = contactService.updateContact(1L, updateRequest);

        assertNotNull(response);
        assertEquals("Anuj", response.getFirstName());
        assertEquals("Vishwakarma", response.getLastName());
        assertEquals("anuj.new@example.com", response.getEmail());
        assertEquals("9876543210", response.getPhone());
        assertEquals("9123456789", response.getAlternatePhone());
        assertTrue(response.isFavourite());

        verify(contactRepository).findById(1L);
        verify(contactRepository).save(existingContact);
    }

    @Test
    void shouldReturnNullWhenUpdatingNonExistingContact() {
        Contact updateRequest = new Contact(null, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", false);

        when(contactRepository.findById(99L)).thenReturn(Optional.empty());

        Contact response = contactService.updateContact(99L, updateRequest);

        assertNull(response);

        verify(contactRepository).findById(99L);
        verify(contactRepository, never()).save(any(Contact.class));
    }

    @Test
    void shouldDeleteContact() {
        contactService.deleteContact(1L);

        verify(contactRepository).deleteById(1L);
    }

    @Test
    void shouldSearchContactsByName() {
        Contact contact = new Contact(1L, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", false);

        when(contactRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("Anuj", "Anuj"))
                .thenReturn(Arrays.asList(contact));

        List<Contact> results = contactService.searchContactsByName("Anuj");

        assertEquals(1, results.size());
        assertEquals("Anuj", results.get(0).getFirstName());
        verify(contactRepository).findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("Anuj", "Anuj");
    }

    @Test
    void shouldGetAllContactsWhenSearchNameIsEmpty() {
        Contact contact = new Contact(1L, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", false);

        when(contactRepository.findAll()).thenReturn(Arrays.asList(contact));

        List<Contact> results = contactService.searchContactsByName("  ");

        assertEquals(1, results.size());
        verify(contactRepository).findAll();
    }

    @Test
    void shouldGetFavouriteContacts() {
        Contact favContact = new Contact(1L, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", true);

        when(contactRepository.findByIsFavouriteTrue()).thenReturn(Arrays.asList(favContact));

        List<Contact> favourites = contactService.getFavouriteContacts();

        assertEquals(1, favourites.size());
        assertTrue(favourites.get(0).isFavourite());
        verify(contactRepository).findByIsFavouriteTrue();
    }

    @Test
    void shouldToggleFavouriteContact() {
        Contact contact = new Contact(1L, "Anuj", "Vishwakarma", "anuj@example.com", "9876543210", "9123456789", false);

        when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));
        when(contactRepository.save(any(Contact.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Contact response = contactService.toggleFavourite(1L);

        assertNotNull(response);
        assertTrue(response.isFavourite());
        verify(contactRepository).findById(1L);
        verify(contactRepository).save(contact);
    }

    @Test
    void shouldReturnNullWhenTogglingFavouriteOfNonExistingContact() {
        when(contactRepository.findById(99L)).thenReturn(Optional.empty());

        Contact response = contactService.toggleFavourite(99L);

        assertNull(response);
        verify(contactRepository).findById(99L);
        verify(contactRepository, never()).save(any(Contact.class));
    }
}
