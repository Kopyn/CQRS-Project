package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.api.messages.UpdateCustomerCommand;
import reactor.core.publisher.Mono;

public class UpdateCustomerCommandHandler implements CommandHandler<UpdateCustomerCommand, Void> {
    @Override
    public Mono<Void> handle(UpdateCustomerCommand command) {
        return Mono.empty();
    }
}
