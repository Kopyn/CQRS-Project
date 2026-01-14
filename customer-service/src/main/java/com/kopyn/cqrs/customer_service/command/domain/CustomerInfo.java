package com.kopyn.cqrs.customer_service.command.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class CustomerInfo {

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String documentNumber;
    private boolean deleted; // proper would be some status CREATED, DELETED


    public CustomerInfo(String firstName, String middleName, String lastName, LocalDate birthDate,
                    String documentNumber, boolean deleted) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
        this.deleted = deleted;
    }

    public CustomerInfo(CustomerInfo other) {
        this.firstName = other.firstName;
        this.middleName = other.middleName;
        this.lastName = other.lastName;
        this.birthDate = other.birthDate;
        this.documentNumber = other.documentNumber;
        this.deleted = other.deleted;
    }
}
