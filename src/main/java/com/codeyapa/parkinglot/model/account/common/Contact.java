package com.codeyapa.parkinglot.model.account.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Contact {
    private Contact(){}
    private String phoneNumber;
    private String email;
}
