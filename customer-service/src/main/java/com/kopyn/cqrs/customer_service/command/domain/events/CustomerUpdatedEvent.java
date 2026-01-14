package com.kopyn.cqrs.customer_service.command.domain.events;

import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;

public record CustomerUpdatedEvent(
        CustomerInfo customerInfo
) implements Event {
}
