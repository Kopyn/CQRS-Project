package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.api.messages.UpdateCustomerCommand;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateCustomerCommandHandler implements CommandHandler<UpdateCustomerCommand, Void> {
    @Override
    public Mono<Void> handle(UpdateCustomerCommand command) {
        return Mono.empty();
    }

    @Override
    public Class<UpdateCustomerCommand> getCommandType() {
        return UpdateCustomerCommand.class;
    }
}
