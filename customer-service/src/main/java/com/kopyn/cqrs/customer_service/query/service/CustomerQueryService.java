package com.kopyn.cqrs.customer_service.query.service;

import com.kopyn.cqrs.customer_service.domain.Customer;
import com.kopyn.cqrs.customer_service.query.api.messages.GetAllCustomersQuery;
import com.kopyn.cqrs.customer_service.query.api.messages.GetCustomerByUUIDQuery;
import com.kopyn.cqrs.customer_service.query.api.dto.CustomerDTO;
import com.kopyn.cqrs.customer_service.query.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerQueryService {

    private final CustomerQueryBus queryBus;
    private final CustomerMapper mapper;

    public Mono<CustomerDTO> getCustomerByUUID(UUID uuid) {
        Mono<Customer> customerMono = Mono.from(queryBus.handleQuery(new GetCustomerByUUIDQuery(uuid)));
        return customerMono.map(mapper::toDTO);
    }

    public Flux<CustomerDTO> getAllCustomers() {
        Flux<Customer> customerFlux = Flux.from(queryBus.handleQuery(new GetAllCustomersQuery()));
        return customerFlux.map(mapper::toDTO);
    }
}
