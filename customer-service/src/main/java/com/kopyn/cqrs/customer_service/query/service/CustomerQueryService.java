package com.kopyn.cqrs.customer_service.query.service;

import com.kopyn.cqrs.customer_service.query.dto.CustomerDTO;
import com.kopyn.cqrs.customer_service.query.mapper.CustomerMapper;
import com.kopyn.cqrs.customer_service.query.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerQueryService {

    private final CustomerRepository customerViewRepository;
    private final CustomerMapper mapper;


    public Mono<CustomerDTO> getCustomerByUUID(UUID uuid) {
        return customerViewRepository.getCustomerById(uuid).map(mapper::toDTO);
    }

    public Flux<CustomerDTO> getAllCustomers() {
        return customerViewRepository.getAllCustomers()
                .map(mapper::toDTO);
    }
}
