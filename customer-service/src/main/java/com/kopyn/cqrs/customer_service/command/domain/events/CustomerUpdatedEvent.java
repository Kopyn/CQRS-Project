package com.kopyn.cqrs.customer_service.command.domain.events;

import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;

import java.util.UUID;

public record CustomerUpdatedEvent(
        UUID uuid,
        CustomerInfo customerInfo
) implements Event {
}
