package com.kopyn.cqrs.customer_service.query.controller;

import com.kopyn.cqrs.customer_service.query.dto.CustomerDTO;
import com.kopyn.cqrs.customer_service.query.service.CustomerQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerQueryController {

    private final CustomerQueryService queryService;

    public CustomerQueryController(CustomerQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{uuid}")
    public Mono<CustomerDTO> getCustomerById(UUID uuid) {
        return queryService.getCustomerByUUID(uuid);
    }

    @GetMapping
    public Flux<CustomerDTO> getAllCustomers() {
        return queryService.getAllCustomers();
    }
}
