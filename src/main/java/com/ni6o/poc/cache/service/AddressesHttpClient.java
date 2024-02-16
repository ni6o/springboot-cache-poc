package com.ni6o.poc.cache.service;

import com.ni6o.poc.cache.model.Address;

public interface AddressesHttpClient {

    Address getById(Long id);
}
