package com.kopyn.cqrs.customer_service.command.service;

import com.kopyn.cqrs.customer_service.command.api.messages.CreateCustomerCommand;
import com.kopyn.cqrs.customer_service.command.api.messages.DeleteCustomerCommand;
import com.kopyn.cqrs.customer_service.command.api.messages.UpdateCustomerCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerCommandService {

    private final CustomerCommandBus commandBus;

    public Mono<Void> createCustomer(CreateCustomerCommand createCustomerCommand) {
        return commandBus.handle(createCustomerCommand);
    }

    public Mono<Void> updateCustomer(UpdateCustomerCommand updateCustomerCommand) {
        return commandBus.handle(updateCustomerCommand);
    }

    public Mono<Void> deleteCustomer(DeleteCustomerCommand deleteCustomerCommand) {
        return commandBus.handle(deleteCustomerCommand);
    }

}
