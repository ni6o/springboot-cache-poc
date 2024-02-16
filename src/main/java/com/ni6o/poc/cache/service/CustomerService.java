package com.ni6o.poc.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ni6o.poc.cache.model.Address;
import com.ni6o.poc.cache.model.Contact;
import com.ni6o.poc.cache.model.Customer;
import com.ni6o.poc.cache.repository.ContactsRepository;

@Service
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private AddressesHttpClient addressesHttpClient;

    public Contact getContacts(Customer customer) {
        logger.info("Getting contact for customer with tax code: " + customer.getTaxCode());
        return contactsRepository.getContact(customer);
    }

    @Cacheable(value = "addresses", key = "#customerId")
    public Address getAddressesFromHttpService(Long customerId) {
        logger.info("Getting address from http service for customer with id: " + customerId);
        return addressesHttpClient.getById(customerId);
    }
}
