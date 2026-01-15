package com.kopyn.cqrs.customer_service.command.repository;

import com.kopyn.cqrs.customer_service.command.domain.CustomerAggregate;
import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Wrapper class for EventStore repository. This class is introduced to abstract specific event store
 * implementation via EventStoreRepository interface. This allows changing event store from KurrentDB to MongoDB,
 * Relational database or any other data store that is sufficient for event store.
 */
@RequiredArgsConstructor
@Repository
public class CustomerRepository {

    private final EventStoreRepository esRepository;

    public void saveEvents(List<Event> uncommitedEvents) {

    }

    public CustomerAggregate findCustomerById(UUID uuid) {
        return null;
    }

}
