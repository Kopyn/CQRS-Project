package com.kopyn.cqrs.customer_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class Customer {

    private final UUID uuid;
    private final String firstName;
    private String middleName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String documentNumber;

}
