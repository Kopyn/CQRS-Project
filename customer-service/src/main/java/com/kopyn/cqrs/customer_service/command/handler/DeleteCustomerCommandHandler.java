package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.api.messages.DeleteCustomerCommand;
import reactor.core.publisher.Mono;

public class DeleteCustomerCommandHandler implements CommandHandler<DeleteCustomerCommand, Void> {
    @Override
    public Mono<Void> handle(DeleteCustomerCommand command) {
        return Mono.empty();
    }
}
