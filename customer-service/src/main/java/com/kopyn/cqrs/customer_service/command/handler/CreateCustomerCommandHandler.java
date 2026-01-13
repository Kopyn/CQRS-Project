package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.api.messages.CreateCustomerCommand;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, Void> {
    @Override
    public Mono<Void> handle(CreateCustomerCommand command) {
        return Mono.empty();
    }

    @Override
    public Class<CreateCustomerCommand> getCommandType() {
        return CreateCustomerCommand.class;
    }
}
