package com.kopyn.cqrs.customer_service.command.api.messages;

import java.time.LocalDate;

public record CreateCustomerCommand(
        String firstName,
        String middleName,
        String lastName,
        LocalDate birthDate,
        String documentNumber
) implements Command {
}
