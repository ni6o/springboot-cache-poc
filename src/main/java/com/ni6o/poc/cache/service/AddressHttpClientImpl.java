package com.ni6o.poc.cache.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ni6o.poc.cache.model.Address;

@Service
public class AddressHttpClientImpl implements AddressesHttpClient {

    private static final java.lang.String URL_PATH_SEPARATOR = "/";

    @Value("${addresses.service.url}")
    private String addressesServiceUrl;

    @Override
    public Address getById(Long id) {
        String url = String.join(URL_PATH_SEPARATOR, addressesServiceUrl, String.valueOf(id));
        try {
            return new RestTemplate().getForEntity(url, Address.class).getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Error while getting address by id: " + id, e);
        }
    }

}
