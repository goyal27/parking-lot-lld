package com.codeyapa.parkinglot.model.account;

import com.codeyapa.parkinglot.model.account.common.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public abstract class Account {
    private String id;
    private String username;
    private String password;
    private Person person;

}
