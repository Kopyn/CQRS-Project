package com.kopyn.cqrs.customer_service.command.api.controller;

import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;
import com.kopyn.cqrs.customer_service.command.service.CustomerCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController("/customers")
@RequiredArgsConstructor
public class CustomerCommandController {

    private final CustomerCommandService commandService;

    @PostMapping
    public Mono<Void> createCustomer(CustomerInfo customerInfo) {
        return commandService.createCustomer(customerInfo);
    }

    @PutMapping(path = "/{customerId}/")
    public Mono<Void> updateCustomer(@PathVariable UUID customerId, CustomerInfo customerInfo) {
        return commandService.createCustomer(customerInfo);
    }

    @DeleteMapping(path = "/{customerId}/")
    public Mono<Void> deleteCustomer(@PathVariable UUID customerId) {
        return commandService.deleteCustomer(customerId);
    }

}
