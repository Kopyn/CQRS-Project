package com.kopyn.cqrs.customer_service.command.domain.events;

import lombok.Getter;

import java.time.Instant;

/**
 * This class is representation of events in the event store - other events are internal application representation
 * this will be unified for all events
 */
public class EventModel {
    private String eventId;
    private Instant eventTimestamp;
    private String aggregateId;
    @Getter
    private Event eventData;
    private int aggregateVersion;
}
