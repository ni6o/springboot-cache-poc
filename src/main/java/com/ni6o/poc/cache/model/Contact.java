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
public class Contact implements Serializable {

    private String phoneNumber;
    private String email;
    private String fax;
    private String webSite;
}
