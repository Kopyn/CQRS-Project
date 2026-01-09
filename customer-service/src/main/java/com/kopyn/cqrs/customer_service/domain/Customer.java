package com.kopyn.cqrs.customer_service.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@ToString
@Builder
@NoArgsConstructor
public class Customer {

    private UUID uuid;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String documentNumber;


    public Customer(UUID uuid, String firstName, String middleName, String lastName, LocalDate birthDate,
                    String documentNumber) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
    }
}
