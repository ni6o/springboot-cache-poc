package com.ni6o.poc.cache.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Address implements Serializable {

    private String street;
    private String city;
    private String country;
    private String zipCode;
    private String state;

}
