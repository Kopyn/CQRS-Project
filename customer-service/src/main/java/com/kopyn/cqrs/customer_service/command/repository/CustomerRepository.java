package com.kopyn.cqrs.customer_service.command.repository;

import com.kopyn.cqrs.customer_service.command.domain.CustomerAggregate;
import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import com.kopyn.cqrs.customer_service.command.domain.events.EventModel;
import com.kopyn.cqrs.customer_service.command.mapper.EventModelMapper;
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
    private final EventModelMapper mapper;

    public void saveEvents(List<Event> uncommitedEvents) {
        uncommitedEvents.stream().map(mapper::mapToEventModel).forEach(esRepository::save);
    }

    public CustomerAggregate findCustomerById(UUID uuid) {
        CustomerAggregate customerAggregate = new CustomerAggregate();
        List<EventModel> pastEvents = esRepository.findByAggregateId(uuid.toString());
        pastEvents.forEach(eventModel -> customerAggregate.apply(eventModel.getEventData()));
        return customerAggregate;
    }

}
