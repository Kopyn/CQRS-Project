package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.api.messages.DeleteCustomerCommand;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteCustomerCommandHandler implements CommandHandler<DeleteCustomerCommand, Void> {
    @Override
    public Mono<Void> handle(DeleteCustomerCommand command) {
        return Mono.empty();
    }

    @Override
    public Class<DeleteCustomerCommand> getCommandType() {
        return DeleteCustomerCommand.class;
    }
}
