package com.kopyn.cqrs.customer_service.query.model;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public class CustomerView {

    private final UUID uuid;
    private final String firstName;
    private String middleName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String documentNumber;

    public CustomerView(UUID uuid, String firstName, String middleName, String lastName, LocalDate birthDate,
                    String documentNumber) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
}
