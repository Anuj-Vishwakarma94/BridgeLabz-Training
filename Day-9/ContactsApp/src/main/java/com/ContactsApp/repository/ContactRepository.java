package com.ContactsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ContactsApp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    List<Contact> findByIsFavouriteTrue();
}