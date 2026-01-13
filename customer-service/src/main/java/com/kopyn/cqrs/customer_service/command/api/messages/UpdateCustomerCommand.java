package com.kopyn.cqrs.customer_service.command.api.messages;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateCustomerCommand (
        UUID uuid,
        String firstName,
        String middleName,
        String lastName,
        LocalDate birthDate,
        String documentNumber
) implements Command {
}
