package com.kopyn.cqrs.customer_service.command.domain.events;

public interface Event {
    String getAggregateId();
    int getAggregateVersion();
}
