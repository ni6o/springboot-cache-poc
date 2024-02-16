package com.ni6o.poc.cache.repository;

import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ni6o.poc.cache.model.Contact;
import com.ni6o.poc.cache.model.Customer;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;

@Repository
public class ContactsRepository {

    private Logger logger = (Logger) LoggerFactory.getLogger(ContactsRepository.class);

    private static final HashMap<String, Contact> contacts = new HashMap<>();

    @PostConstruct
    public void init() {
        contacts.put("taxCode1", Contact.builder().phoneNumber("0000000001").email("test1@mail.com").fax("fax1")
                .webSite("webSite1").build());
        contacts.put("taxCode2", Contact.builder().phoneNumber("0000000002").email("test2@mail.com").fax("fax2")
                .webSite("webSite2").build());
        contacts.put("taxCode3", Contact.builder().phoneNumber("0000000003").email("test3@mail.com").fax("fax3")
                .webSite("webSite3").build());
    }

    @Cacheable(value = "contacts", key = "#customer.taxCode")
    public Contact getContact(Customer customer) {
        logger.info("Waiting 3s to get contact for customer with tax code: " + customer.getTaxCode());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.error("Error while getting contact for customer with tax code: " + customer.getTaxCode(), e);
        }
        return contacts.get(customer.getTaxCode());
    }
}
