package com.kopyn.cqrs.customer_service.command.domain.commands;

import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;

import java.util.UUID;

public record CreateCustomerCommand(
        UUID uuid,
        CustomerInfo customerInfo
) implements Command {
}
