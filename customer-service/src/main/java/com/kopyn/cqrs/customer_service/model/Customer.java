package com.kopyn.cqrs.customer_service.model;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {
    private final UUID uuid;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String documentNumber;
}
