package com.ni6o.poc.cache.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ni6o.poc.cache.model.Address;
import com.ni6o.poc.cache.model.Contact;
import com.ni6o.poc.cache.model.Customer;
import com.ni6o.poc.cache.service.CustomerService;

@RestController
public class PocCacheController {

    private final Logger logger = LoggerFactory.getLogger(PocCacheController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/contact")
    public ResponseEntity<Contact> getCache(@RequestBody Customer customer,
            @RequestHeader("request-id") String requestId) {
        return ResponseEntity.ok().header("request-id", requestId).body(customerService.getContacts(customer));
    }

    @GetMapping("/address/{customerId}")
    public ResponseEntity<Address> getCache(@PathVariable("customerId") Long customerId,
            @RequestHeader("request-id") String requestId) {
        logger.info(
                String.format("Retrieving address for customerId: %1$s and request-id: %2$s", customerId, requestId));
        return ResponseEntity.ok().header("request-id", requestId)
                .body(customerService.getAddressesFromHttpService(customerId));
    }

}
