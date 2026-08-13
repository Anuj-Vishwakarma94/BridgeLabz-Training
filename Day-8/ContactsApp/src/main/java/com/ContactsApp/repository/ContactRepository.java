package com.ContactsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ContactsApp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}