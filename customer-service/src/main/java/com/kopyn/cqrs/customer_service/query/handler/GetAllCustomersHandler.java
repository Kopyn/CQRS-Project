package com.kopyn.cqrs.customer_service.query.handler;

import com.kopyn.cqrs.customer_service.domain.Customer;
import com.kopyn.cqrs.customer_service.query.api.messages.GetAllCustomersQuery;
import com.kopyn.cqrs.customer_service.query.repository.CustomerQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class GetAllCustomersHandler implements QueryHandler<GetAllCustomersQuery, Customer> {

    private final CustomerQueryRepository customerViewRepository;

    @Override
    public Class<GetAllCustomersQuery> getQueryType() {
        return GetAllCustomersQuery.class;
    }

    public Flux<Customer> handle(GetAllCustomersQuery query) {
        return customerViewRepository.getAllCustomers();
    }
}
