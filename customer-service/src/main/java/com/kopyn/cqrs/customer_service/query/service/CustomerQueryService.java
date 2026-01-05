package com.kopyn.cqrs.customer_service.query.service;

import com.kopyn.cqrs.customer_service.query.model.CustomerView;
import com.kopyn.cqrs.customer_service.query.repository.CustomerViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CustomerQueryService {

    private final CustomerViewRepository customerViewRepository;


    public CustomerQueryService(@Autowired CustomerViewRepository customerViewRepository) {
        this.customerViewRepository = customerViewRepository;
    }

    public Mono<CustomerView> getCustomerByUUID(UUID uuid) {
        return customerViewRepository.getCustomerById(uuid);
    }

    public Flux<CustomerView> getAllCustomers() {
        return customerViewRepository.getAllCustomers();
    }
}
