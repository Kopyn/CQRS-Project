package com.kopyn.cqrs.customer_service.query.handler;

import com.kopyn.cqrs.customer_service.domain.Customer;
import com.kopyn.cqrs.customer_service.query.api.GetCustomerByUUIDQuery;
import com.kopyn.cqrs.customer_service.query.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetCustomerByUUIDHandler implements QueryHandler<GetCustomerByUUIDQuery, Customer> {

    private final CustomerRepository customerViewRepository;

    @Override
    public Class<GetCustomerByUUIDQuery> getQueryType() {
        return GetCustomerByUUIDQuery.class;
    }

    @Override
    public Publisher<Customer> handle(GetCustomerByUUIDQuery query) {
        return customerViewRepository.getCustomerById(query.uuid());
    }
}
