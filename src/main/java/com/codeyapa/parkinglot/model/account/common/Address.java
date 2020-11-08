package com.codeyapa.parkinglot.model.account.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {
    private Address() {
    }

    private String addressLine1;
    private String addressLine2;
    private String street;
    private String city;
    private String country;
    private String zipcode;
}
