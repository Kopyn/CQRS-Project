package com.kopyn.cqrs.customer_service.command.domain.events;

import java.util.UUID;

public record CustomerDeletedEvent(
        UUID uuid
) implements Event {
}
