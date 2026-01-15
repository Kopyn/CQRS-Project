package com.kopyn.cqrs.customer_service.command.repository;

import org.springframework.stereotype.Repository;

@Repository
/**
 * Class used for specific implementation of Event Store. It is only used for retrieving and saving Events!
 * You shouldn't use domain specific classes here
 */
public interface EventStoreRepository {
}
