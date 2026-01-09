package com.kopyn.cqrs.customer_service.query.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
public class CustomerDTO {

    private final UUID uuid;
    private final String firstName;
    private String middleName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String documentNumber;

}
