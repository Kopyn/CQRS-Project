package com.kopyn.cqrs.customer_service.command.api.controller;

import com.kopyn.cqrs.customer_service.command.domain.commands.CreateCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;
import com.kopyn.cqrs.customer_service.command.service.CustomerCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/customers")
@RequiredArgsConstructor
public class CustomerCommandController {

    private final CustomerCommandService commandService;

    @PostMapping
    public Mono<Void> createCustomer(CustomerInfo customerInfo) {
        return commandService.createCustomer(customerInfo);
    }

}
