package com.kopyn.cqrs.customer_service.command.mapper;

import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import com.kopyn.cqrs.customer_service.command.domain.events.EventModel;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class EventModelMapper {
    public EventModel mapToEventModel(Event event) {
        return null;
    }
}
