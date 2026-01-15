package com.kopyn.cqrs.customer_service.command.repository;

import com.kopyn.cqrs.customer_service.command.domain.events.EventModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * Class used for specific implementation of Event Store. It is only used for retrieving and saving Events!
 * You shouldn't use domain specific classes here
 */
public interface EventStoreRepository {
    void save(EventModel event);
    List<EventModel> findByAggregateId(String aggregateId);
    List<EventModel> findAll();
}
