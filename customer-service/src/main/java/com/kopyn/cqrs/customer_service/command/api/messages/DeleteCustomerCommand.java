package com.kopyn.cqrs.customer_service.command.api.messages;

import java.util.UUID;

public record DeleteCustomerCommand(
        UUID uuid
) implements Command {
}
